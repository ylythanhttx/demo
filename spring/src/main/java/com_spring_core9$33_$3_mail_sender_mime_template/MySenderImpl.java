package com_spring_core9$33_$3_mail_sender_mime_template;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * @author thanh
 *
 */

@Component("mySender")
public class MySenderImpl implements MySender {

	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;
	@Autowired
	VelocityEngine velocityEngine;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void sendMail(MailObject mailObject) {

		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		try {
			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(mailObject.getTo());
			helper.setFrom(mailObject.getFrom());
			helper.setCc(mailObject.getCc());
			helper.setReplyTo(mailObject.getReplyTo());
			helper.setSubject(mailObject.getSubject());
			helper.setSentDate(new Date());
			helper.addAttachment("Sv.java", new File(
					"/home/thanh/AMysoft/Developer/MyGit/demo/spring/src/main/java/com_spring_core9$23_jmx_jconsole/Sv.java"));

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("userName", "Nguyen Van Thanh");
			model.put("products", new ArrayList<Map<String, Object>>());
			List<Map<String, Object>> maps = (List<Map<String, Object>>) model.get("products");
			Map<String, Object> product1 = new HashMap<String, Object>();
			product1.put("id", 1);
			product1.put("name", "A");
			Map<String, Object> product2 = new HashMap<String, Object>();
			product2.put("id", 2);
			product2.put("name", "B");
			Map<String, Object> product3 = new HashMap<String, Object>();
			product3.put("id", 3);
			product3.put("name", "C");
			maps.add(product1);
			maps.add(product2);
			maps.add(product3);
			String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					"com_spring_core9$33_$3_mail_sender_mime_template/MailToCusomer.vm", model);
			
			//inner html
			helper.setText(text,true);
			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
