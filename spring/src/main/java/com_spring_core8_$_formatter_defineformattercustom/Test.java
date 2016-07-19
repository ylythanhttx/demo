package com_spring_core8_$_formatter_defineformattercustom;

import java.text.ParseException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class Test {

	public static void main(String[] args) throws ParseException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring861-1.xml");
		ConversionService conversionService = (ConversionService)context.getBean("conversionService");
	
		Person person = (Person) context.getBean("person");

		//Date được inject như String
		System.out.println(person.getDate());
		
		//Chuyển 1 chuỗi thành date từ conversionService
		System.out.println(conversionService.convert("07-07-2018", Date.class));
		
		//Chuyển đổi 1 object thành 1 chuỗi
		System.out.println(conversionService.convert(new Date(), String.class));
	}

}
