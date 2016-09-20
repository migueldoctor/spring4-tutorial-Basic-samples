package com.tutorial.naturalprogrammer.spring.sample9.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	/*
	 * Using @Value annotation and ${} syntax
	 * the value of the property will be injected
	 * from application.properties file to the 
	 * current java class
	 */
	@Value("${app.property}")
	private String sProperty;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello " + sProperty;
	}

}
