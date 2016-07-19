package com_spring_core6_$5_beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring65.xml");

		A a = (A) context.getBean("a");

		System.out.println(a.getA());
		a.setA("hello");
		A a1 = (A) context.getBean("a");

		System.out.println(a1.getA());

		System.out.println("==================");

		B b = (B) context.getBean("b");

		System.out.println(b.getB());
		b.setB("hello");
		B b1 = (B) context.getBean("b");

		System.out.println(b1.getB());

	}

}
