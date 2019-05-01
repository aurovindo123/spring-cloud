package com.user.management.microservices.springclouduserregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudUserRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUserRegistrationApplication.class, args);
	}

}
