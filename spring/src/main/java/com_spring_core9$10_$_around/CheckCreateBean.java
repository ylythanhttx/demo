/**
 * File Name  : CheckCreateBean.java
 * Package          :com.spring.core9$10.$.around
 * Author           : thanhnv5
 * Created    : Oct 28, 2015

 * This source code is part of the  spring, and is copyrighted by DTSC. 
 * All rights reserved.  No part of this work may be reproduced, stored in a retrieval system,
 * adopted or transmitted in any form or by any means,electronic, mechanical, photographic,
 * graphic, optic recording or otherwise,translated in any language or computer language,
 * without the prior written permission of DTSC 

Copyright © 2010 - 2015 by DTSC
-------------------------------------------------------------------
 * Version Control:
 *       $LastChangedRevision$
 *       $LastChangedBy$
 *       $LastChangedDate$
 * 
-------------------------------------------------------------------
 */

package com_spring_core9$10_$_around;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author thanhnv5
 *
 */
public class CheckCreateBean implements BeanPostProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#
	 * postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName);
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#
	 * postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
