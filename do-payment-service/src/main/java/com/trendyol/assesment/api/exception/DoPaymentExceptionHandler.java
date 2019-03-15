package com.trendyol.assesment.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Generic exception handler.
 */
@ControllerAdvice
public class DoPaymentExceptionHandler {

	@ExceptionHandler(value = MissingRequestException.class)
	public ResponseEntity<Object> exception() {
		return new ResponseEntity<>("Request can not be null!", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> internalServerError() {
		return new ResponseEntity<>("Ops! Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
