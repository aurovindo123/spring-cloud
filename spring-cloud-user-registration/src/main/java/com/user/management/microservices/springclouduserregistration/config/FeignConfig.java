package com.user.management.microservices.springclouduserregistration.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@FeignClient(name="spring-cloud-user-login", url="http://localhost:8000")
public interface FeignConfig {
	
	@GetMapping("/login/{userName}/{pass}")
	public ModelAndView login(@PathVariable String userName,@PathVariable String pass);
	
}
