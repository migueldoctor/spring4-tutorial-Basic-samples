package com.tutorial.naturalprogrammer.spring.sample10.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tutorial.naturalprogrammer.spring.sample10.mail.MailSender;
import com.tutorial.naturalprogrammer.spring.sample10.mail.MockMailSender;
import com.tutorial.naturalprogrammer.spring.sample10.mail.SmtpMailSender;

@Configuration
public class MailConfig {
	//Using Profiles we don't need to define qualifiers to decide which
	//bean needs to be injected. In this example we will use mock mail when
	//dev is defined in spring.profile.active and smtp mail otherwise

	@Bean
	@Profile("dev")
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
	
	@Bean
	@Profile("!dev")
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
}
