package com.user.management.microservices.springclouduserlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.management.microservices.springclouduserlogin.repository.UserLoginRepository;
import com.user.management.microservices.springclouduserlogin.repository.entity.UserAuth;
import com.user.management.microservices.springclouduserlogin.service.UserLoginService;

@RestController
public class LoginController {
		
	@Autowired
	UserLoginService service;
	
	@Autowired
	UserLoginRepository repository;
	
	@GetMapping("/login/{userName}/{pass}")
	public ModelAndView login(String userName, String pass) {
		ModelAndView mav = new  ModelAndView();
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
}
