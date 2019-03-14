package com.trendyol.assesment.api.domain;

public class ValidateCreditCardResponse {
	private CardValidationStatus cardValidationStatus;

	public CardValidationStatus getCardValidationStatus() {
		return cardValidationStatus;
	}

	public void setCardValidationStatus(CardValidationStatus cardValidationStatus) {
		this.cardValidationStatus = cardValidationStatus;
	}
}
