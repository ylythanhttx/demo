/**
 * File Name  : LTW.java
 * Package          :com.spring.core9$10.$.around
 * Author           : thanhnv5
 * Created    : Oct 29, 2015

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

import java.lang.instrument.ClassFileTransformer;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.instrument.classloading.LoadTimeWeaver;

/**
 * @author thanhnv5
 *
 */
public class LTW /*extends LTWImpl*/ implements LoadTimeWeaver,
		BeanClassLoaderAware, DisposableBean {

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBeanClassLoader(ClassLoader arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTransformer(ClassFileTransformer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClassLoader getInstrumentableClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassLoader getThrowawayClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}
}
