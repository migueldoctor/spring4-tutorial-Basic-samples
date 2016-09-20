package com.tutorial.naturalprogrammer.spring.sample8.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//@Component now we remove this annotation, which means that this class is not
// included within Application Context. Instead of @Component we are going to 
// create another type of Spring service called CONFIGURATION CLASS
//In our case it will be called MailConfig class
public class MockMailSender implements MailSender {
	
	private static final Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MOCK mail to " + to); 
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}

}
