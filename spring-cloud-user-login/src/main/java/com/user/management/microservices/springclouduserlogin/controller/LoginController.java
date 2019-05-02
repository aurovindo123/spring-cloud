package com.user.management.microservices.springclouduserlogin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.management.microservices.springclouduserlogin.repository.UserLoginRepository;
import com.user.management.microservices.springclouduserlogin.repository.entity.UserAuth;
import com.user.management.microservices.springclouduserlogin.service.UserLoginService;

@RestController
public class LoginController {
		private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserLoginService service;
	
	@Autowired
	UserLoginRepository repository;
	
	@GetMapping("/login/{userName}/{pass}")
	public ModelAndView login(@PathVariable String userName,@PathVariable String pass) {
		ModelAndView mav = new ModelAndView();
		logger.info("The User name is : "+userName);
		boolean flag = service.loginWithCredential(userName,pass);
		if(flag) {
			mav.setViewName("startPage");
		}else {
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@GetMapping("/users")
	public List<UserAuth> getUser() {
		return repository.findAll();
	}
	
	@GetMapping(value="/validate/{userName}/{password}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean validate(@PathVariable String userName, @PathVariable String password) {
		return service.loginWithCredential(userName,password);
	}
}
