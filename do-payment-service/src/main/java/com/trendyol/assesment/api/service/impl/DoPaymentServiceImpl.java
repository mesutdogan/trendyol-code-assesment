package com.trendyol.assesment.api.service.impl;

import com.trendyol.assesment.api.domain.*;
import com.trendyol.assesment.api.domain.external.CardValidationStatus;
import com.trendyol.assesment.api.domain.external.ValidateCreditCardRequest;
import com.trendyol.assesment.api.domain.external.ValidateCreditCardResponse;
import com.trendyol.assesment.api.repository.DoPaymentRepository;
import com.trendyol.assesment.api.service.DoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class DoPaymentServiceImpl implements DoPaymentService {

	private CreditCardClient creditCardClient;

	private DoPaymentRepository doPaymentRepository;

	@Autowired
	public DoPaymentServiceImpl(CreditCardClient creditCardClient, DoPaymentRepository doPaymentRepository) {
		this.doPaymentRepository = doPaymentRepository;
		this.creditCardClient = creditCardClient;
	}

	/**
	 * Create a payment object in database if credit card is valid.
	 *
	 * @param doPaymentRequest
	 * @return {@link DoPaymentResponse}
	 */
	@Transactional
	@Override
	public DoPaymentResponse doPayment(DoPaymentRequest doPaymentRequest) {
		DoPaymentResponse doPaymentResponse = new DoPaymentResponse();
		Payment payment = preparePaymentObject(doPaymentRequest);
		ValidateCreditCardResponse validateCreditCardResponse = validateCreditCard(
				doPaymentRequest.getCreditCardNumber());
		if (CardValidationStatus.INVALID == validateCreditCardResponse.getCardValidationStatus()) {
			doPaymentResponse.setStatus(PaymentStatus.FAILED);
			return doPaymentResponse;
		}
		payment = doPaymentRepository.save(payment);
		doPaymentResponse.setStatus(PaymentStatus.SUCCEEDED);
		doPaymentResponse.setPaymentId(payment.getId());
		return doPaymentResponse;
	}

	/**
	 * Makes an http call to external service to validate credit card.
	 *
	 * @param creditCardNumber
	 * @return {@link ValidateCreditCardResponse}
	 */
	public ValidateCreditCardResponse validateCreditCard(String creditCardNumber) {
		ValidateCreditCardRequest validateCreditCardRequest = new ValidateCreditCardRequest();
		validateCreditCardRequest.setCardNumber(creditCardNumber);
		return creditCardClient.validateCreditCard(validateCreditCardRequest);
	}

	/**
	 * Create payment object by using request object.
	 *
	 * @param doPaymentRequest
	 * @return {@link Payment}
	 */
	public Payment preparePaymentObject(DoPaymentRequest doPaymentRequest) {
		assert doPaymentRequest != null;
		Payment payment = new Payment();
		payment.setCustomerId(doPaymentRequest.getCustomerId());
		payment.setDate(LocalDateTime.now());
		payment.setPaymentReference(UUID.randomUUID().toString());
		payment.setTotalPrice(doPaymentRequest.getTotalPrice());
		return payment;
	}
}
