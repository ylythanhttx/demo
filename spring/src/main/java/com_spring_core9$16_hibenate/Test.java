package com_spring_core9$16_hibenate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/databasehibernate.xml");
		
//		ActorDaoImpl actorDao = (ActorDaoImpl) context.getBean("actorDaoImpl");
//		System.out.println(actorDao.getActor().size());
//		actorDao.upadteActor("firstName10");
//		context.registerShutdownHook();
		
//		TransactionManager jbossTransactionManager = (TransactionManager) context.getBean("jbossTransactionManager");
//		JtaTransactionManager transactionManager = (JtaTransactionManager) context.getBean("transactionManager");
		
		TestServiceImpl testServiceImpl = (TestServiceImpl) context.getBean("testServiceImpl");
		testServiceImpl.testService("123456");
	}
}
