package com.mifuturoempleo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/security/home").setViewName("security/home");
		registry.addViewController("/security/aboutus").setViewName("security/aboutus");
		//registry.addViewController("/").setViewName("home");
		registry.addViewController("/security/private-area").setViewName("security/private-area");
		registry.addViewController("/security/login").setViewName("security/login");

		

	}

}