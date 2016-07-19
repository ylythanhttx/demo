package com_spring_core6_$44_lazyinitbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {

		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring644.xml");

	}

}
