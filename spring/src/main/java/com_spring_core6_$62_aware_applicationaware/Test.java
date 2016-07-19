package com_spring_core6_$62_aware_applicationaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring662-1.xml");

		System.out.println(context==AppContext.getApplicationContext());
	}

}
