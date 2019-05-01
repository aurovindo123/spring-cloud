package com.user.management.microservices.springclouduserregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.user.management.microservices.springclouduserregistration.bean.User;
import com.user.management.microservices.springclouduserregistration.config.FeignConfig;
import com.user.management.microservices.springclouduserregistration.repository.UserRegistrationDAO;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRegistrationDAO dao;

	public void saveRegistrationDetails(User user) {
		dao.save(user);
	}

}
