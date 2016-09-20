package com.tutorial.naturalprogrammer.spring.sample13.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SmtpMailSender implements MailSender {

	// We declare an instance of a JavaMailSender object with its set method
	private JavaMailSender javaMailSender;
			
	public void setJavaMailSender(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	@Override
	public void send(String to, String subject, String body) {
		MimeMessage message = javaMailSender.createMimeMessage(); 
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);	
			// true indicates multipart message
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body, true);
			// true indicates html
		} catch (MessagingException e) {
			e.printStackTrace(); 
		} 
		// continue using helper for more functionalities 
		// like adding attachments, etc.
		javaMailSender.send(message);
	}
}
