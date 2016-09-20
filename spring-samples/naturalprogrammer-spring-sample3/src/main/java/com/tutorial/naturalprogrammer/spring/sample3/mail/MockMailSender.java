package com.tutorial.naturalprogrammer.spring.sample3.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 * By annotating with @Component we are putting this class 
 * within the ApplicationContext so Spring can instantiate 
 * objects from this class to inject it where @Resource is coded.
 * 
 * We annotate the class with @Primary to give this class priority
 * when more than one compatible class is annotated with @Component
 */
@Primary //This is optional, but only can be used in one class
@Component
public class MockMailSender implements MailSender {

	private static final Log log = 
			LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MOCK mail to " + to); 
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
