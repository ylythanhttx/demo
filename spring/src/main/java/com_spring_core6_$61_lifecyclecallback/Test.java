package com_spring_core6_$61_lifecyclecallback;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring661.xml");

         X x = (X)context.getBean("x");
         
         System.out.println(x.getX());
         
         context.registerShutdownHook();

	}

}
