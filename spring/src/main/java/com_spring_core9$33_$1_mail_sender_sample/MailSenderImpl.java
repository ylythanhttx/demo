package com_spring_core9$33_$1_mail_sender_sample;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component("mailSender")
public class MailSenderImpl implements MailSender {

	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;
	
	public void sendMail(MailObject mailObject) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailObject.getTo());
		mailMessage.setFrom(mailObject.getFrom());
		mailMessage.setCc(mailObject.getCc());
		mailMessage.setReplyTo(mailObject.getReplyTo());
		mailMessage.setText(mailObject.getText());
		mailMessage.setSubject(mailObject.getSubject());
		mailMessage.setSentDate(new Date());
//		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
//		mailSenderImpl.setHost("smtp.gmail.com");
//		mailSenderImpl.setPort(25);
//		mailSenderImpl.setUsername("ttx.facebook.uit@gmail.com");
//		mailSenderImpl.setPassword("@Qq77641176");
		javaMailSenderImpl.send(mailMessage);
	}
}
