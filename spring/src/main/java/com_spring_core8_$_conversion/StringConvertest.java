package com_spring_core8_$_conversion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringConvertest implements ConverterFactory<Date, String>{

	
//	public <T extends Date> Converter<String, T> getConverter(
//			Class<T> targetType) {
//		// TODO Auto-generated method stub
//		return new StringToDate<T>();
//	}

	@SuppressWarnings("hiding")
	public static class DateToString<String> implements Converter<Date, String>{

		@SuppressWarnings("unchecked")
		@Override
		public String convert(Date source) {

			java.lang.String date = new SimpleDateFormat("dd-MM-yyyy").format(source);
			return (String) date;
//			return null;ring
		}

	
	}

	@Override
	public <T extends String> Converter<Date, T> getConverter(
			Class<T> targetType) {
		// TODO Auto-generated method stub
		return new DateToString();
	}

}
