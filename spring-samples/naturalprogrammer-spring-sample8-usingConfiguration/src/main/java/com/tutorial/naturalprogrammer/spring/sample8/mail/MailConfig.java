package com.tutorial.naturalprogrammer.spring.sample8.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//We can use @Configuration annotation for placing several classes within the
//Spring application Context. This kind of classes are used to avoid
//annotating all bean classes with @Component annotation

@Configuration
public class MailConfig {

	//Then we create methods with the name of the classes in camelCase
	//returning a new object of each classes. 	
	//The name of the method can be whatever you want, 
	//but it will be the name of the bean 
	//to be used when @Qualified() is used
	//These methods will be annotated with @Bean
	
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
	
	@Bean
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
}
