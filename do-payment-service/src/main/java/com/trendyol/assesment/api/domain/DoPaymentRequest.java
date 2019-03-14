package com.trendyol.assesment.api.domain;

/**
 * This class holds the attributes to be converted to {@link Payment}
 * object - which will be persisted in database.
 *
 * @author Mesut Dogan
 * @version 0.0.1
 */
public class DoPaymentRequest {

	private PaymentStatus status;
	private String customerId;
	private Double totalPrice;
	private String paymentReference;
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

}
