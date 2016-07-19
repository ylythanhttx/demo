package com_spring_core6_$9$151_i18n;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring6151.xml");

		MessageSource messageSource = (MessageSource) context.getBean("messageSource");
		
		
		System.out.println(messageSource.getMessage("thanks",new String[]{"bạn"},new Locale("vi")));
		
		System.out.println(messageSource.getMessage("thanks",new String[]{"Socola"},new Locale("en")));

		
	}

}
