package com_spring_core8_$_formatter_annotation;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws ParseException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring861-2.xml");
//		ConversionService conversionService = (ConversionService)context.getBean("conversionService");
		Person person = (Person) context.getBean("person");

		System.out.println(person.getDate());
		
//		System.out.println(conversionService.convert("07-07-2018", Date.class));
//		System.out.println(conversionService.convert(new Date(), String.class));
		
		
	}

}
