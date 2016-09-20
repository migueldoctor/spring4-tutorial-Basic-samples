package com.tutorial.naturalprogrammer.spring.sample6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.naturalprogrammer.spring.sample6.mail.MailSender;

@RestController
public class MailController {

	private MailSender mailSender;
	
	/* So far we know @Resource to inject objects from the application Context.
	 * This is great, but @Resource can ONLY be use above class properties or setMethods,
	 * which is called PROPERTY INJECTION and SET INJECTION
	 * 
	 * To solve this limitation spring provides us with @Autowire
	 * Let's create a constructor of the controller and inject using @Autowire
	 * THIS MODALITY IS CALLED CONSTRUCTOR INJECTION AND IT'S THE RECOMMENDED ONE
	 * FOR MAKING EASIER THE TESTING 
	 * 
	 * 	     @Autowired
	 *		 public MailController(MailSender mailSender) {
	 *			this.mailSender = mailSender;
	 *		 }
	 * 
	 * NOTE: @Autowired doesn't work with names, as happened with @Resource. But
	 *       it works with @Qualifier . So in order to solve ambiguities we need
	 *       to add @Qualifier("name") in the bean just below @Component.
	 *   	 Then use @Qualifier("name") before the parameter to be injected
	 *       
	 *       By default all beans have a qualifier which is the name of the class in 
	 *       camelCase
	 *       
	 *       @Autowired
	 *		 public MailController(@Qualifier("smtpMailSender)MailSender mailSender) {
	 *			this.mailSender = mailSender;
	 *		 }
	 */
	@Autowired
	public MailController(@Qualifier("mockMailSender") MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send("abc@example.com", "Some subject", "the content"); 
		return "Mail sent";
	}
}
