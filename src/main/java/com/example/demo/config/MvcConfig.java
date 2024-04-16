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
		
		registry.addViewController("login").setViewName("login");//loginのリダイレクト
		registry.addViewController("reset").setViewName("reset");//resetのリダイレクト
		registry.addViewController("botton").setViewName("botton");//bottonのリダイレクト
		registry.addViewController("change").setViewName("change");//changeのリダイレクト
		registry.addViewController("add").setViewName("add");//addのリダイレクト
	}
	
}
