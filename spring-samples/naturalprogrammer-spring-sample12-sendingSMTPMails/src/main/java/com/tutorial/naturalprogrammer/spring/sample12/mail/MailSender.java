package com.tutorial.naturalprogrammer.spring.sample12.mail;

public interface MailSender {
	void send(String to, String subject, String body);
}
