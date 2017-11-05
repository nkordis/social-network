package com.socialnetwork.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Value("${mail.smtp.host}")
	private String host;
	
	@Value("${mail.smtp.user}")
	private String username;
	
	@Value("${mail.smtp.port}")
	private int port;
	
	@Value("${mail.smtp.pass}")
	private String password;
	
	@Bean
	public JavaMailSender mailSender(){
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setUsername(username);
		mailSender.setPort(port);
		mailSender.setPassword(password);
		
		
		return mailSender;
	}
	
}




