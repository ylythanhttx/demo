/**
 * File Name  : UnitTest.java
 * Package          :
 * Author           : thanhnv5
 * Created    : Oct 26, 2015

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
package com_unitest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author thanhnv5
 *
 */
@ContextConfiguration(locations = { "classpath:**/spring10-5.xml" })
public class UnitTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring10-5.xml");
		System.out.println(context);
		System.out.println(com_dtsc_helijobfair_main_server_utils_test.Test
				.test());
	}
}
