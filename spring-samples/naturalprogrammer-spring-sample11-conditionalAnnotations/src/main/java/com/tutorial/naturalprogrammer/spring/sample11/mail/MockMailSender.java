package com.tutorial.naturalprogrammer.spring.sample11.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockMailSender implements MailSender {
	
	private static final Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MOCK mail to " + to); 
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}

}
