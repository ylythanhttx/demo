package com_spring_core9$33_$2_mail_sender_mime_attach;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author thanh
 *
 */
public class App {

	/**
	 * add javax mail
	 * turn on map of map/pop gmail
	 * turn on google security if using server mail google: smtp.google.com: 
	 * https://www.google.com/settings/security/lesssecureapps
	 * if not authen, disable capcha:
	 * https://accounts.google.com/b/0/DisplayUnlockCaptcha
	 * 
	 */
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/spring-33-2.xml");
		MySender mailSender = (MySender) context.getBean("mySender");
		MailObject mailObject = new MailObject();
		mailObject.setTo("");
		mailObject.setFrom("");
		mailObject.setCc(new String[]{});
		mailObject.setReplyTo("");
		mailObject.setText("Test sendmail");
		mailObject.setSubject("Test sendmail");
		mailObject.setSentDate(new Date());
		mailSender.sendMail(mailObject);
	}

}
