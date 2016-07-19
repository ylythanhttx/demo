package com_spring_core8_$_conversion;

import java.text.ParseException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class Test {

	/**
	 * Conversion la bo chuyen doi giua cac kieu luc chay ung dung,
	 * chang han nhu bean person co field date kieu Date.class, nhung co 
	 * the bieu dien nhu kieu String.class (spring851.xml)
	 * Nho vao bo chuyen doi (code & config) spring tu chuyen doi chuoi 
	 * trong file cau hinh thanh Date
	 * 
	 * Hoac co the dung ConversionService de test cac vi du khac nhu ben duoi
	 */
	public static void main(String[] args) throws ParseException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring851.xml");
		Person person = (Person) context.getBean("person");

		System.out.println(person.getDate());
		
		ConversionService conversionService = (ConversionService)context.getBean("conversionService");
		
		System.out.println(conversionService.convert("09-09-2018", Date.class));
		System.out.println(conversionService.convert(new Date(), String.class));
	}

}
