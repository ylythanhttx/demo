package com_spring_core6_$62_aware_beannameaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring662-2.xml");

        X x = (X) context.getBean("x");
       
        System.out.println(x.getBeanName());
        

	}

}
