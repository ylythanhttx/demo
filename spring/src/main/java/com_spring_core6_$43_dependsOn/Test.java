package com_spring_core6_$43_dependsOn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring643.xml");

	}

}
