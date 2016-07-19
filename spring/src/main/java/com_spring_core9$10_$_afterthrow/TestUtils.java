/**
 * File Name  : TestUtils.java
 * Package          :com.dtsc.helijobfair.main.server.authentication.test
 * Author           : thanhnv5
 * Created    : Oct 23, 2015

 * This source code is part of the  helijobfair-main-server, and is copyrighted by DTSC. 
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

package com_spring_core9$10_$_afterthrow;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author thanhnv5
 * 
 */
@Aspect
public class TestUtils {

//	private static String userName;
//
//	@Around("execution(* com.dtsc.helijobfair.main.server.utils.test.Test.*(..)")
//	public String getUserName(ProceedingJoinPoint joinPoint)  throws Throwable{
//
//		System.out.println("a");
//		try {
//			return (String) joinPoint.proceed();
//		} catch (Throwable e) {
//
//			if (userName == null) {
//				return "test16101@mailinator.com";
//			}
//			return userName;
//		}
//	}
//
//	public static String getUserName() {
//		return userName;
//	}
//
//	public static void setUserName(String userName) {
//		TestUtils.userName = userName;
//	}

	@Around("execution(* com.dtsc.helijobfair.main.server.utils.test.Test.*(..))")
	public String around(ProceedingJoinPoint pjp) throws Throwable{
		//before
		System.out.println("before");
		
		try {
		
			Object x = pjp.proceed();
		} catch (Exception e) {

		}
		

		//after
		System.out.println("after"); 
		return "s";
	}
}
