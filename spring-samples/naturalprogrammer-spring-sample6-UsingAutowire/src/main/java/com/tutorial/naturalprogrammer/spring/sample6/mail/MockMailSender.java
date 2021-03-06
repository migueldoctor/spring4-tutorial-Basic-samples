package com.tutorial.naturalprogrammer.spring.sample6.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component //Makes the object be included in the application context, which means that Spring can look for it and inject it
public class MockMailSender implements MailSender {
	
	private static final Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MOCK mail to " + to); 
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}

}
