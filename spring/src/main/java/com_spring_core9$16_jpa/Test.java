package com_spring_core9$16_jpa;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/jpa/database.xml");
		
		ActorDaoImpl actorDao = (ActorDaoImpl) context.getBean("actorDaoImpl");
		System.out.println(actorDao.getActor().size());
	}
}
