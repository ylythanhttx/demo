package com_spring_core8_$_formatter_defineformattercustom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatTest implements Formatter<Date> {

	private String pattern;

	public DateFormatTest() {
		super();
	}

	public DateFormatTest(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	@Override
	public String print(Date object, Locale locale) {

		return new SimpleDateFormat(getPattern()).format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {

		return new SimpleDateFormat(getPattern()).parse(text);
	}

	/**
	 * @param pattern
	 *            the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
