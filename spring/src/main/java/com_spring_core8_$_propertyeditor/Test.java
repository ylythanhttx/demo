package com_spring_core8_$_propertyeditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring842.xml");
		
		Person person = (Person) context.getBean("person");
		System.out.println(person.getDate());
	}

}
