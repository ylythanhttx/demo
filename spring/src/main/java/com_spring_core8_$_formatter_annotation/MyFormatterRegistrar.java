package com_spring_core8_$_formatter_annotation;

import java.util.Date;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class MyFormatterRegistrar implements FormatterRegistrar {

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(Date.class, new DateFormatTest(
				"dd-MM-yyyy"));
	}
}