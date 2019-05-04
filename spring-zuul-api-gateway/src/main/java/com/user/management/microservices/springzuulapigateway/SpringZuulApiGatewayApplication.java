package com.user.management.microservices.springzuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApiGatewayApplication.class, args);
	}
	

}
