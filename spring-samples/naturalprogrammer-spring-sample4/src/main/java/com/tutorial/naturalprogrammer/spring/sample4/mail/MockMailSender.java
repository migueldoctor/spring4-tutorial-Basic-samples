package com.tutorial.naturalprogrammer.spring.sample4.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.tutorial.naturalprogrammer.spring.sample4.mail.MailSender;

/*
 * By annotating with @Component("abc") we are putting this class within the 
 * ApplicationContext with the name "abc". So the @Resource annotation needs
 * to include this name. @Resource(name="abc"). 
 * IF YOU DON'T ASSIGN A NAME THE DEFAULT ONE IS THE NAME OF THE CLASS 
 * IN CAMELCASE
 */
@Component("mockSender")
public class MockMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MOCK mail to " + to); 
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
