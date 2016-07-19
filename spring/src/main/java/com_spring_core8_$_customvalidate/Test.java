package com_spring_core8_$_customvalidate;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.validation.Validator;

public class Test {

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring8.xml");

		Sv sv = (Sv) context.getBean("sv");
		Test test = (Test) context.getBean("test");
		sv.setAge(1);
		try {
			test.print(null);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(((ValidException) e).getMapMsg());
		}
	}

	@TargetCheck(0)
	public void print(Sv sv) {
		System.out.println(sv);
	}
}
