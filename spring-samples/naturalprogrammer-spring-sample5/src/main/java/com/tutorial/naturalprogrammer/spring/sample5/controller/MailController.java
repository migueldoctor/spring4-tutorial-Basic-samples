package com.tutorial.naturalprogrammer.spring.sample5.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.naturalprogrammer.spring.sample5.mail.MailSender;

@RestController
public class MailController {

	//@Resource The Resource Annotation can be placed above a SET method instead of
	//			above this attribute. Using @Resource in the attribute is known as 
	//			PROPERTY INJECTION and it's not recommended bcz of it makes testing more 
	//			complicated
	private MailSender mailSender;
	
	//@Resource SET INJECTION: So you can create a set method and use the annotation here
	//						   This is called SET INJECTION
	@Resource   
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	// ************************************************************************
	// CONCLUSION: @Resource can be used ONLY above class fields and set methods
	//			   WHICH MEANS ONLY FOR PROPERTY AND SET INJECTION
	// ************************************************************************
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send("abc@example.com", "Some subject", "the content"); 
		return "Mail sent";
	}
	
}
