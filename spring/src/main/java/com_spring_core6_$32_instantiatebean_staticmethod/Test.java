package com_spring_core6_$32_instantiatebean_staticmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring632-2.xml");

         Sv sv = (Sv)context.getBean("sv");

         System.out.println(sv.getName());
	}

}
