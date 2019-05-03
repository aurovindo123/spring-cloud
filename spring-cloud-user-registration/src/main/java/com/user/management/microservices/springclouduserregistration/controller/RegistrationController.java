package com.user.management.microservices.springclouduserregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.user.management.microservices.springclouduserregistration.bean.User;
import com.user.management.microservices.springclouduserregistration.config.FeignConfig;
import com.user.management.microservices.springclouduserregistration.service.UserRegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserRegistrationService service;
	
	@Autowired
	private FeignConfig feignProxy;

	@GetMapping("/index")
	public String show() {
		
		return "index";  
	}
	
	@PostMapping(value="/register", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String registerUser(@RequestBody User user) {
		ModelAndView mav = new ModelAndView();
		service.saveRegistrationDetails(user);
		boolean flag = feignProxy.validate(user.getUserName(),user.getPassword());
		if(flag) {
			return "welcome to startpage";
		}else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid user");
		}
	}
}
