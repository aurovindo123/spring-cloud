package com.user.management.microservices.springclouduserlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class SpringCloudUserLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUserLoginApplication.class, args);
	}
	 @Bean
	    public InternalResourceViewResolver setupViewResolver()  {
	        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
	        resolver.setPrefix ("/jsp/");
	        resolver.setSuffix (".jsp");
	        resolver.setViewClass (JstlView.class);
	        return resolver;
	    }
}
