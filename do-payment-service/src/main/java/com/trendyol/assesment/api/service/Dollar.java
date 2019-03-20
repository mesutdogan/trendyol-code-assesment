package com.trendyol.assesment.api.service;

public class Dollar {
	private int amount;

	public Dollar(int i) {
		this.amount = i;
	}

	public Dollar times(int i) {
		this.amount = i * amount;
		return new Dollar(i);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
