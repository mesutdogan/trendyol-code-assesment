package com.trendyol.assesment.api.service;

import com.trendyol.assesment.api.domain.*;
import com.trendyol.assesment.api.domain.external.CardValidationStatus;
import com.trendyol.assesment.api.domain.external.ValidateCreditCardRequest;
import com.trendyol.assesment.api.domain.external.ValidateCreditCardResponse;
import com.trendyol.assesment.api.exception.MissingRequestException;
import com.trendyol.assesment.api.repository.DoPaymentRepository;
import com.trendyol.assesment.api.service.impl.DoPaymentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class DoPaymentServiceTest {

	@Mock
	private DoPaymentRepository doPaymentRepository;

	@Mock
	private CreditCardClient creditCardClient;

	private DoPaymentService doPaymentService;

	private DoPaymentRequest doPaymentRequest;

	private Payment dummyPaymentObject;

	private ValidateCreditCardResponse invalidCardValidationResponse;

	private ValidateCreditCardResponse validCardValidationResponse;

	@Before
	public void setup() {
		initMocks(this);
		doPaymentService = new DoPaymentServiceImpl(creditCardClient, doPaymentRepository);
		//initialize dummy request
		doPaymentRequest = new DoPaymentRequest();
		doPaymentRequest.setCustomerId("1");
		doPaymentRequest.setTotalPrice(32.20);

		dummyPaymentObject = new Payment();
		dummyPaymentObject.setId(12345L);

		invalidCardValidationResponse = new ValidateCreditCardResponse();
		validCardValidationResponse = new ValidateCreditCardResponse();
		invalidCardValidationResponse.setCardValidationStatus(CardValidationStatus.INVALID);
		validCardValidationResponse.setCardValidationStatus(CardValidationStatus.VALID);
	}

	@Test
	public void whenCreditCardIsValid_thenPaymentShouldBeSucceeded() {
		Mockito.when(creditCardClient.validateCreditCard(Mockito.any(ValidateCreditCardRequest.class)))
				.thenReturn(validCardValidationResponse);
		Mockito.when(doPaymentRepository.save(Mockito.any(Payment.class))).thenReturn(dummyPaymentObject);
		DoPaymentResponse doPaymentResponse = doPaymentService.doPayment(doPaymentRequest);
		Assert.assertTrue(PaymentStatus.SUCCEEDED.equals(doPaymentResponse.getStatus()));
	}

	@Test
	public void whenCreditCardIsInValid_thenPaymentShouldBeFailed() {
		Mockito.when(creditCardClient.validateCreditCard(Mockito.any(ValidateCreditCardRequest.class)))
				.thenReturn(invalidCardValidationResponse);

		DoPaymentResponse doPaymentResponse = doPaymentService.doPayment(doPaymentRequest);
		Assert.assertTrue(PaymentStatus.FAILED.equals(doPaymentResponse.getStatus()));
	}

	@Test
	public void whenPaymentIsInsertedDatabase_thenIdFieldShouldNonNull() {
		Mockito.when(creditCardClient.validateCreditCard(Mockito.any(ValidateCreditCardRequest.class)))
				.thenReturn(validCardValidationResponse);

		Mockito.when(doPaymentRepository.save(Mockito.any(Payment.class))).thenReturn(dummyPaymentObject);

		DoPaymentResponse doPaymentResponse = doPaymentService.doPayment(doPaymentRequest);
		Assert.assertNotNull(doPaymentResponse.getPaymentId());
		//development2
	}

	@Test(expected = MissingRequestException.class)
	public void whenPaymentRequestsNull_thenThrowAssertionError() {
		doPaymentService.preparePaymentObject(null);
	}

	@Test
	public void whenPaymentRequestIsNotNull_thenPaymentEntityFieldsShouldBeFilled() {
		Payment payment = doPaymentService.preparePaymentObject(doPaymentRequest);
		Assert.assertNotNull(payment.getCustomerId());
		Assert.assertNotNull(payment.getDate());
		Assert.assertNotNull(payment.getPaymentReference());
		Assert.assertNotNull(payment.getTotalPrice());
	}
}
