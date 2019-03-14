package com.trendyol.assesment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulExampleApplication.class, args);
	}
}
