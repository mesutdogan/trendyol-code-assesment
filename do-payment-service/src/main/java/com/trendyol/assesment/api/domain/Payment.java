package com.trendyol.assesment.api.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class represents actual Payment object.
 */
@Table(name = "payment")
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime date;
	private PaymentStatus status;
	private String customerId;
	private Double totalPrice;
	private String paymentReference;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Payment payment = (Payment) o;
		return Objects.equals(date, payment.date) &&
				status == payment.status &&
				Objects.equals(customerId, payment.customerId) &&
				Objects.equals(totalPrice, payment.totalPrice) &&
				Objects.equals(paymentReference, payment.paymentReference);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, status, customerId, totalPrice, paymentReference);
	}
}
