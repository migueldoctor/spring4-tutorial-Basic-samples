package com.tutorial.naturalprogrammer.spring.sample4.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.naturalprogrammer.spring.sample4.mail.MailSender;

@RestController
public class MailController {

	/* IMPORTANT: By using @Resource(name="abc") with a name parameter
	 * 			  we ask spring to look for a class annotated with 
	 * 			  @Component(name="abc") 
	 */
	//@Resource(name="smtpSender")
	@Resource(name="mockSender")
	private MailSender mailSender;

	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send("abc@example.com", "Some subject", "the content"); 
		return "Mail sent";
	}
	
}
