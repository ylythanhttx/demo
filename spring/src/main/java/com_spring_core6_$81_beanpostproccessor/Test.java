package com_spring_core6_$81_beanpostproccessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring681.xml");

        X x = (X) context.getBean("x1");
        System.out.println(x.getBeanName());
        context.registerShutdownHook();
        

	}

}
