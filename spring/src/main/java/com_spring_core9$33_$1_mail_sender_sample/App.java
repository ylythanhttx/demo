package com_spring_core9$33_$1_mail_sender_sample;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * add javax mail
	 * turn on google security if using server mail google: smtp.google.com: 
	 * https://www.google.com/settings/security/lesssecureapps
	 * if not authen, disable capcha:
	 * https://accounts.google.com/b/0/DisplayUnlockCaptcha
	 * 
	 */
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/spring-33-1.xml");
		MySender mailSender = (MySender) context.getBean("mySender");
		MailObject mailObject = new MailObject();
		mailObject.setTo("");
		mailObject.setFrom("");
		mailObject.setCc(null);
		mailObject.setReplyTo("");
		mailObject.setText("Test sendmail");
		mailObject.setSubject("Test sendmail");
		mailObject.setSentDate(new Date());
		mailSender.sendMail(mailObject);
	}

}
