package com.trendyol.assesment.api.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigure {
	public static int connectTimeOutMillis = 120000;
    public static int readTimeOutMillis = 120000;
    @Bean
    public Request.Options options() {
           return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }
}
