package com_spring_core6_$62_aware_applicationaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContext implements ApplicationContextAware {

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext(){
		return context;
	}
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		this.context = applicationContext;
	}

}
