package com_spring_core9$33_$2_mail_sender_mime_attach;

import java.io.File;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 
 * @author thanh
 *
 */
@Component("mySender")
public class MySenderImpl implements MySender {

	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;

	public void sendMail(MailObject mailObject) {

		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		try {
			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(mailObject.getTo());
			helper.setFrom(mailObject.getFrom());
			helper.setCc(mailObject.getCc());
			helper.setReplyTo(mailObject.getReplyTo());
			helper.setText(mailObject.getText());
			helper.setSubject(mailObject.getSubject());
			helper.setSentDate(new Date());
			helper.addAttachment("Sv.java", new File("/home/thanh/AMysoft/Developer/MyGit/demo/spring/src/main/java/com_spring_core9$23_jmx_jconsole/Sv.java"));
			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
