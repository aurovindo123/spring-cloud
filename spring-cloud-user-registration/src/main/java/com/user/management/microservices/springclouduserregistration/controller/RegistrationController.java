package com.user.management.microservices.springclouduserregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
	public ModelAndView show() {
		ModelAndView modelAndView = new ModelAndView(); 
		User user = new User();
		modelAndView.setViewName("index"); 
		modelAndView.addObject("user", user);
		return modelAndView;  
	}
	
	@PostMapping(value="/register", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView registerUser(@RequestBody User user) {
		ModelAndView mav = new ModelAndView();
		service.saveRegistrationDetails(user);
		boolean flag = feignProxy.validate(user.getUserName(),user.getPassword());
		mav.addObject("user", user);
		mav.setViewName("startPage");
		return mav;
	}
}
