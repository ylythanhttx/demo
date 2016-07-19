package com_spring_core9$23_jmx_jconsole;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.ParseException;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.quartz.SchedulerException;

public class Test {

	// static{
	// Class<?> clazz = LTWImpl.class;
	// }
//start jconsole : jsonsole (commandline)
	public static void main(String[] args) throws IOException,
			InterruptedException, SchedulerException, ParseException,
			MalformedObjectNameException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException {

		// testRunJob();
		System.out.println(java.lang.management.ManagementFactory
				.getRuntimeMXBean().getName());
		// System.out.println(java.lang.management.ManagementFactory.getPlatformMBeanServer().getDomains());
		// RuntimeMXBean runtimeMXBean = java.lang.management.ManagementFactory
		// .getRuntimeMXBean();
		// System.out.println(runtimeMXBean.getVmVersion());
		// System.out.println(runtimeMXBean.getVmVendor());
		// System.out.println(runtimeMXBean.getVmName());
		// System.out.println(runtimeMXBean.getSystemProperties());
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		ObjectName objectName = new ObjectName(
				"com.spring.core9$23.jmx.jconsole:type=Sv");
		Sv sv = new Sv();
		mBeanServer.registerMBean(sv, objectName);
		Thread.sleep(Long.MAX_VALUE);
	}
}
