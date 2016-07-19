package com_spring_core9$21_mvc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestCreateBean implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {

		if("testHttpRequest".equals(beanName)){
			System.out.println("before create request");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		if(bean instanceof TestHttpRequest){
			System.out.println("after create request");
		}
		return bean;
	}

	

}
