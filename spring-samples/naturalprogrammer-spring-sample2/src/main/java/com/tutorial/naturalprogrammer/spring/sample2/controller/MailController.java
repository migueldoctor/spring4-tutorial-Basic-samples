package com.tutorial.naturalprogrammer.spring.sample2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.naturalprogrammer.spring.sample2.mail.MailSender;
import com.tutorial.naturalprogrammer.spring.sample2.mail.MockMailSender;

@RestController
public class MailController {

	// IMPORTANT: WE HAVE TO EXPLICITLY INSTANCE THE CLASS VIA NEW OPERATOR
	// THIS IS NOT MAINTAINABLE SO HERE IS WHERE DEPENDENCY INJECTION SHOWS UP
	// TO SOLVE THIS PROBLEM. SEE Sample3 to see how to apply D.I. here.
	MailSender mailSender = new MockMailSender();
	//MailSender mailSender = new SmtpMailSender();
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send("abc@example.com", "Some subject", "the content"); 
		return "Mail sent";
	}
}


