package com.user.management.microservices.springclouduserlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.microservices.springclouduserlogin.repository.UserLoginRepository;
import com.user.management.microservices.springclouduserlogin.repository.entity.UserAuth;

@Service
public class UserLoginService {
	
	@Autowired
	UserLoginRepository repository;
	
	public boolean loginWithCredential(String userName, String pass) {
		UserAuth user = repository.findByUserNameAndPass(userName, pass);
		if(user!=null) {
			return true;
		}
		return false;
	}
}
