package com.trendyol.assesment.api.domain;

import java.time.LocalDateTime;
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
}
