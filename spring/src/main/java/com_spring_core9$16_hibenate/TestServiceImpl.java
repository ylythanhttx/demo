package com_spring_core9$16_hibenate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class TestServiceImpl {

	@Autowired
	private ActorDaoImpl actorDaoImpl;
	
	@Autowired
	private TableDaoImpl tableDaoImpl;
	
	public void testService(String firstName){
		actorDaoImpl.upadteActor(firstName);
		
		tableDaoImpl.getTable1(1);
	}
}
