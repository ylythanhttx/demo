package com_spring_core6_$46_lookupmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring646.xml");
		
		Abc abc = (Abc) context.getBean("abc");
		
		System.out.println(abc.getX().getHello());
	}
	
}
