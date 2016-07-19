package com_spring_core9$16_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com_spring_core9$16_data_sakila.Actor;

@Component
@Transactional
public class ActorDaoImpl {

	@PersistenceContext(unitName="sakila_unit")
	private EntityManager em;
	
	public List getActor(){
		Query query = em.createQuery("SELECT firstName FROM Actor");
 
		return query.getResultList();
	}
	
}
