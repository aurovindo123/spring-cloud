package com.user.management.microservices.springclouduserregistration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@GetMapping("/index")
	public String show() {
		return "index";
	}
}
