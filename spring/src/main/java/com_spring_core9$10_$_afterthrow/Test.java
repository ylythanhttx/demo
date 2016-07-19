package com_spring_core9$10_$_afterthrow;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring10-4.xml");
		
		X x = (X) context.getBean("x");
		try {
			x.testThowException();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
