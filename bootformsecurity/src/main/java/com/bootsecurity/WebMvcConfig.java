package com.bootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/account.htm").setViewName("account");
		registry.addViewController("/home.htm").setViewName("home");
		registry.addViewController("/login.htm").setViewName("login");
		registry.addViewController("/logout.htm").setViewName("logout");
	}

	
}
