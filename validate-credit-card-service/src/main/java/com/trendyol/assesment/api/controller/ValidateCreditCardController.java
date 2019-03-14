package com.trendyol.assesment.api.controller;

import com.trendyol.assesment.api.domain.CardValidationStatus;
import com.trendyol.assesment.api.domain.ValidateCreditCardResponse;
import com.trendyol.assesment.api.domain.ValidateCreditCardRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Dummy http end point and it always return {@link CardValidationStatus#VALID} response.
 */
@RestController
@RequestMapping(value = "/credit-card")
public class ValidateCreditCardController {

	@RequestMapping(method = RequestMethod.POST, value = "/validate")
	public ValidateCreditCardResponse validateCard(
			@RequestBody
					ValidateCreditCardRequest validateCreditCardRequest) {
		ValidateCreditCardResponse dummyAnswer = new ValidateCreditCardResponse();
		dummyAnswer.setCardValidationStatus(CardValidationStatus.VALID);
		return dummyAnswer;
	}
}
