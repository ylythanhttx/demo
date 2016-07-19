package com_spring_core8_$_customvalidate;

import java.util.HashMap;
import java.util.Map;

public class ValidException extends RuntimeException {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1570447235358970599L;

	private Map<String, String> mapMsg = new HashMap<String, String>();

	public ValidException() {
	}

	public ValidException(Map<String, String> mapMsg) {
		this.mapMsg = mapMsg;
	}

	public Map<String, String> getMapMsg() {
		return mapMsg;
	}

}
