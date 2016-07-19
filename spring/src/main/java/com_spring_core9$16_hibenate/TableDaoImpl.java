package com_spring_core9$16_hibenate;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


@Component
public class TableDaoImpl {

	@Resource(name="sessionFactoryTest")
	private SessionFactory sessionFactory;
	
	public void getTable1(Integer id){

//		throw new RuntimeException("test commit");
	}
}
