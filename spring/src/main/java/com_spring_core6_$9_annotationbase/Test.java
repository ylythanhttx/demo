package com_spring_core6_$9_annotationbase;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring9.xml");

         Y y = (Y)context.getBean("y");
         

         System.out.println(y.getX().getX());
         System.out.println(y.getZ().getZ());
         
         context.registerShutdownHook();

	}

}
