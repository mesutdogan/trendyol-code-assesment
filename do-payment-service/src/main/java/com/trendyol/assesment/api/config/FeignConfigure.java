package com.trendyol.assesment.api.config;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigure {

    @Value("feign.connectTimeOut")
    private final static int CONNECT_TIME_OUT_MILLIS = 120000;

    @Value("feign.readTimeOut")
    public final static int READ_TIME_OUT_MILLIS = 120000;
    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIME_OUT_MILLIS, READ_TIME_OUT_MILLIS);
    }
}
