package com.tutorial.naturalprogrammer.spring.sample10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.naturalprogrammer.spring.sample10.mail.MailSender;

@RestController
public class MailController {
	
	private MailSender mailSender;
	
	@Autowired
	public  MailController(MailSender mailSender) {
		this.mailSender=mailSender;
	}
	
	@RequestMapping("/mail")
	public String sendMail()
	{
		mailSender.send("abc@example.com", "Some subject", "the content"); 
		return "Mail sent";
	}

}
