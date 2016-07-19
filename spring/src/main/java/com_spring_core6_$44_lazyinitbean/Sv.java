package com_spring_core6_$44_lazyinitbean;

import org.springframework.beans.factory.InitializingBean;

public class Sv implements InitializingBean{

	private String name;

	public Sv(){
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("init bean sv");
	}
	
	
}
