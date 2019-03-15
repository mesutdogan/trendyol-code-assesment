package com.trendyol.assesment.api.domain;

import java.util.Objects;
/**
 * Do Payment Http Response
 *
 * @author Mesut Dogan
 * @version 0.0.1
 */
public class DoPaymentResponse {

	private PaymentStatus status;

	private Long paymentId;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public void setReason(PaymentStatus succeeded) {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DoPaymentResponse that = (DoPaymentResponse) o;
		return status == that.status &&
				paymentId.equals(that.paymentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, paymentId);
	}
}
