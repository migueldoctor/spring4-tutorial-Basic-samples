package com.tutorial.naturalprogrammer.spring.sample11.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {
/*
	 * Using this conditional on property annotation we will inject
	 * mockMailSender bean if the property is not present in the 
	 * application.properties file. Otherwise, a smtpMailSender bean
	 * will be injected.
	 * There are a lot of parameters for this annotation
	 * like havingValue="google.mail" (required for this case) so
	 * you will inject that bean if that property has that value
	 */
	@Bean
	@ConditionalOnProperty(name="spring.mail.host",
						   matchIfMissing=true,
						   havingValue="foo"
						   )
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
	
	@Bean
	@ConditionalOnProperty(name="spring.mail.host")
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
}



