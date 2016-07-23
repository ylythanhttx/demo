package com_spring_core9$33_$1_mail_sender_sample;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * add javax mail
	 */
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/spring-33-1.xml");
		MailSender mailSender = (MailSender) context.getBean("mailSender");
		MailObject mailObject = new MailObject();
		mailObject.setTo("ttx.facebook.uit@gmail.com");
		mailObject.setFrom("ttx.facebook.uit@gmail.com");
		mailObject.setCc(null);
		mailObject.setReplyTo("ttx.facebook.uit@gmail.com");
		mailObject.setText("Test sendmail");
		mailObject.setSubject("Test sendmail");
		mailObject.setSentDate(new Date());
		mailSender.sendMail(mailObject);
	}

}
