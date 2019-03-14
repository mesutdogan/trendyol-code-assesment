package com.trendyol.assesment.api.domain;

import com.trendyol.assesment.api.config.FeignConfigure;
import com.trendyol.assesment.api.domain.external.ValidateCreditCardRequest;
import com.trendyol.assesment.api.domain.external.ValidateCreditCardResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class helps to establish a http communication between "do-payment-service"
 * and "validate-credit-card-service" named micro services.
 *
 * @author Mesut Dogan
 * @version 0.0.1
 */
@FeignClient(value = "validate-credit-card-service", configuration = FeignConfigure.class)
public interface CreditCardClient {

	@RequestMapping(method = RequestMethod.POST, value = "/credit-card")
	ValidateCreditCardResponse validateCreditCard(ValidateCreditCardRequest validateCreditCardRequest);

}