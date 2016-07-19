package com_spring_core8_$_formatter_annotation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class DateFormatTestAnnotationFormatterFactory implements
		AnnotationFormatterFactory<ADateFormatTest> {

	@Override
	public Set<Class<?>> getFieldTypes() {
		Set<Class<?>> set = new HashSet<Class<?>>();
	    set.add(Date.class);
	    return set;
	}

	@Override
	public Printer<?> getPrinter(ADateFormatTest annotation, Class<?> fieldType) {
		// TODO Auto-generated method stub
		return new DateFormatTest(annotation.pattern());
	}

	@Override
	public Parser<?> getParser(ADateFormatTest annotation, Class<?> fieldType) {
		// TODO Auto-generated method stub
		return new DateFormatTest(annotation.pattern());
	}

}
