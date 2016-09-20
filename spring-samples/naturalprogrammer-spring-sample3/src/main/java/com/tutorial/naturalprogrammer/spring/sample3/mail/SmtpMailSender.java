package com.tutorial.naturalprogrammer.spring.sample3.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/*
 * By annotating with @Component we are putting this class within the 
 * ApplicationContext so Spring can instantiate objects from this class 
 * and inject them where @Resource is coded
 */
@Component
public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);

	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending SMTP mail to " + to); 
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	} 
}
