package com.tutorial.naturalprogrammer.spring.sample.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String HelloWorld() {
		return "Hello World!";
	}
}

