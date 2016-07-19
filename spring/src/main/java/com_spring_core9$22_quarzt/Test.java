package com_spring_core9$22_quarzt;

import java.io.IOException;
import java.text.ParseException;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws IOException,
			InterruptedException, SchedulerException, ParseException {

		// testRunJob();
		testDynamicCron();
	}

	public static void testRunJob() throws InterruptedException {
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring9-22.xml");

		Thread.sleep(10000);
	}

	public static void testDynamicCron() throws InterruptedException,
			SchedulerException, ParseException {
		@SuppressWarnings({ "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring9-22.xml");

		Scheduler scheduler = (Scheduler) context.getBean("scheduler");
		JobDetailImpl jobDetail = (JobDetailImpl) context.getBean("jobDetail");
		CronTriggerImpl cronTrigger = (CronTriggerImpl) context
				.getBean("cronTrigger");
		cronTrigger.setCronExpression("0/10 * * * * ?");

		scheduler.deleteJob(jobDetail.getKey());
		scheduler.scheduleJob(jobDetail, cronTrigger);
		System.out.println(scheduler);
		System.out.println(jobDetail);
		System.out.println(cronTrigger);
		Thread.sleep(10000);
	}
}
