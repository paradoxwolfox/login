package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
*MvcConfig
*
*2024.03.29
*/
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("login").setViewName("login");
		registry.addViewController("reset").setViewName("reset");
		registry.addViewController("botton").setViewName("botton");
	}
	
}
