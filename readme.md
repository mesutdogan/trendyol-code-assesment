# Spring Boot Microservice Docker App with Eureka And Zuul

## Introduction

Application consists of two microservices communicating with each other. 
* `do-payment-service : ` It has a service unit test.
* `validate-credit-card service : ` It has a controller unit test.

## About The Application

The logic behind the application is simple:
Http request is made to `do-payment-service` and it makes the credit card dummy validation by calling `validate-credit-card service`.
If it is valid `do-payment-service` persists Payment object to database and returns response.

## Run Command
```
 mvn clean package && docker-compose up
```
