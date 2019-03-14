package com.trendyol.assesment.api.service;

import com.trendyol.assesment.api.domain.DoPaymentRequest;
import com.trendyol.assesment.api.domain.DoPaymentResponse;
import com.trendyol.assesment.api.domain.Payment;
import com.trendyol.assesment.api.domain.ValidateCreditCardResponse;
import org.springframework.stereotype.Service;

/**
 * Do Payment Service Interface.
 *
 * @author Mesut Dogan
 * @version 0.0.1
 */
public interface DoPaymentService {
	DoPaymentResponse doPayment(DoPaymentRequest doPaymentRequest);

	Payment preparePaymentObject(DoPaymentRequest doPaymentRequest);

	ValidateCreditCardResponse validateCreditCard(String creditCardNumber);
}
