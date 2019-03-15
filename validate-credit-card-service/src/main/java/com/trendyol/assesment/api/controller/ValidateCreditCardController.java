package com.trendyol.assesment.api.controller;

import com.trendyol.assesment.api.domain.CardValidationStatus;
import com.trendyol.assesment.api.domain.ValidateCreditCardRequest;
import com.trendyol.assesment.api.domain.ValidateCreditCardResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dummy http end point and it always return {@link CardValidationStatus#VALID} response.
 */
@RestController
@RequestMapping(value = "/credit-card")
public class ValidateCreditCardController {

	@PostMapping(value = "/validate", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ValidateCreditCardResponse validateCard(
			@RequestBody
					ValidateCreditCardRequest validateCreditCardRequest) {
		ValidateCreditCardResponse dummyAnswer = new ValidateCreditCardResponse();
		dummyAnswer.setCardValidationStatus(CardValidationStatus.VALID);
		return dummyAnswer;
	}
}
