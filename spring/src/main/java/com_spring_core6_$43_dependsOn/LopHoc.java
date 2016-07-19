package com_spring_core6_$43_dependsOn;

import org.springframework.beans.factory.InitializingBean;


public class LopHoc implements InitializingBean{

	private String lopHocName;


	/**
	 * @return the lopHocName
	 */
	public String getLopHocName() {
		return lopHocName;
	}

	/**
	 * @param lopHocName
	 *            the lopHocName to set
	 */
	public void setLopHocName(String lopHocName) {
		this.lopHocName = lopHocName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("init bean lopHoc");
	}

}
