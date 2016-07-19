package com_spring_core8_$_conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class DateConvertest implements ConverterFactory<String, Date>{

	@Override
	public <T extends Date> Converter<String, T> getConverter(
			Class<T> targetType) {
		// TODO Auto-generated method stub
		return new StringToDate<T>();
	}

	public static class StringToDate<T extends Date> implements Converter<String, T>{

		Date date = null;
		@SuppressWarnings("unchecked")
		@Override
		public T convert(String source) {

			try {
				date = new SimpleDateFormat("dd-MM-yyyy").parse(source);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (T) date;
//			return null;
		}

	
	}

}
