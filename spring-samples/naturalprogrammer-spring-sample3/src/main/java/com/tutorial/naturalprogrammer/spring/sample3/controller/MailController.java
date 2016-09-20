package com.tutorial.naturalprogrammer.spring.sample3.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.naturalprogrammer.spring.sample3.mail.MailSender;

@RestController
public class MailController {

	/* IMPORTANT: By using @Resource just before the attribute MailSender
	 * 			  we ask spring to look for a class compatible with the type
	 * 			  (MailSender in this case) within the Application Context.
	 * 			  Classes available within the application context need to
	 * 			  be annotated with @Component (there are more options but 
	 * 			  for this example we use @Component.
	 * 
	 * 			  IN CASE MORE THAN ONE CLASS COMPATIBLE WITH MailSender is
	 * 			  available within the application context, it will inject
	 * 			  the one annotated with @Primary. If no one uses Primary 
	 * 			  an error will be throw.
	 * 
	 */
	@Resource
	MailSender mailSender;
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send("abc@example.com", "Some subject", "the content"); 
		return "Mail sent";
	}
}
