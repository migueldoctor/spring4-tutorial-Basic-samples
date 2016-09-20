package com.tutorial.naturalprogrammer.spring.sample13.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Bean
	@ConditionalOnProperty(name="spring.mail.host",
	   matchIfMissing=true,
	   havingValue="foo")
	public MailSender mockMailSender(){
		return new MockMailSender();
	}
	
	@Bean //SINCE THE CLASS IS ANNOTATED WITH CONFIGURATION, THIS CODE IS EXECUTED WHEN STARTING ONCE
	public DemoBean demoBean()
	{
		return new DemoBean(); 
	}
	
	@Bean
	@ConditionalOnProperty(name="spring.mail.host")
	public MailSender smtpMailSender(JavaMailSender javaMailSenderBean){
		demoBean().foo(); //IF THE CLASS IS ANNOTATED WITH CONFIGURATION, THE METHOD
						  //demoBean IS CACHED WHEN STARTING, SO HERE IS NOT EXECUTED AGAIN
						  //IF THE CLASS IS ANNOTATED WITH @COMPONENT, THEN
						  //THE METHOD WILL BE EXECUTED TWICE, THE FIRST ONE BECAUSE OF THE 
						  //BEAN ANNOTATION AND THE SECOND ONE HERE
		
		SmtpMailSender smtpMailSenderBean = new SmtpMailSender();
		smtpMailSenderBean.setJavaMailSender(javaMailSenderBean);		
		return smtpMailSenderBean;
	}
}
