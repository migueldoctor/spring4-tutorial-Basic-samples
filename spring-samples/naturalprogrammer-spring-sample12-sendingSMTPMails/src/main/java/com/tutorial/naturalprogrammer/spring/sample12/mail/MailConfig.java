package com.tutorial.naturalprogrammer.spring.sample12.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	//Inject javaMailSenderBean from SpringBoot here,
	//Then you can use it in smtpMailSender
	//@Autowired
	//private JavaMailSender javaMailSenderBean;
	
	@Bean
	@ConditionalOnProperty(name="spring.mail.host",
	   matchIfMissing=true,
	   havingValue="foo")
	public MailSender mockMailSender(){
		return new MockMailSender();
	}
	
	//Alternatively since this method is annotated with Bean, 
	//Spring automatically will inject the JavaMailSender reference
	// if passed as argument in the annotated method 
	@Bean
	@ConditionalOnProperty(name="spring.mail.host")
	public MailSender smtpMailSender(JavaMailSender javaMailSenderBean){
		SmtpMailSender smtpMailSenderBean = new SmtpMailSender();
		smtpMailSenderBean.setJavaMailSender(javaMailSenderBean);		
		return smtpMailSenderBean;
	}
}
