package com.trendyol.assesment.api.controller;

import com.trendyol.assesment.api.domain.DoPaymentRequest;
import com.trendyol.assesment.api.domain.DoPaymentResponse;
import com.trendyol.assesment.api.service.DoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Do Payment Controller.
 *
 * @author Mesut Dogan
 * @version 0.0.1
 */

@RestController
@RequestMapping(value = "/do-payment")
public class DoPaymentController {

	@Autowired
	private DoPaymentService doPaymentService;

	protected Logger LOGGER = Logger.getLogger(DoPaymentController.class.getName());

	/**
	 * Delegates do payment request to {@link DoPaymentService#doPayment(DoPaymentRequest)} method
	 * and returns {@link DoPaymentResponse}.
	 *
	 * @param doPaymentRequest
	 * @return
	 */
	@RequestMapping
	public DoPaymentResponse doPayment(
			@RequestBody
			final DoPaymentRequest doPaymentRequest) {
		LOGGER.info("Payment processing started.");
		return doPaymentService.doPayment(doPaymentRequest);
	}
}
