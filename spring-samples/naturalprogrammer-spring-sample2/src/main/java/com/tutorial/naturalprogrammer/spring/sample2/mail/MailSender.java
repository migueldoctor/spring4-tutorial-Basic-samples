package com.tutorial.naturalprogrammer.spring.sample2.mail;

public interface MailSender {

	void send(String to, String subject, String body);
}
