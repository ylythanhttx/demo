package com_spring_core9$16_hibenate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com_spring_core9$16_data_sakila.Actor;

@Component
public class ActorDaoImpl {

	@Resource(name="sessionFactorySakila")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	public List getActor(){
//		return sessionFactory.getCurrentSession().createCriteria(Actor.class).list();
		return sessionFactory.getCurrentSession().createSQLQuery("select * from Actor").list();
	}
	
	public void upadteActor(String firstName){
		Actor actor = (Actor) sessionFactory.getCurrentSession().get(Actor.class, (short)3);
		actor.setFirstName(firstName);
		sessionFactory.getCurrentSession().update(actor);
		sessionFactory.getCurrentSession().flush();
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
