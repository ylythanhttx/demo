package com_spring_core9$_expresstion_xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring9-ex.xml");
		
		Sv1 sv1 = (Sv1) context.getBean("sv1");
		
		System.out.println(sv1.getAge());
		System.out.println(sv1.getName());
		System.out.println(sv1.getDate());
	}

}
