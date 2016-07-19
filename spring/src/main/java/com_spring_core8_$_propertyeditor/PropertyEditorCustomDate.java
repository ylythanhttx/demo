package com_spring_core8_$_propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PropertyEditorCustomDate extends PropertyEditorSupport{

	/**
	 * PropertyEditor cho phép DI 1 kiểu tham chiếu khác bọc nguyên thủy dưới dạng String
	 * hay nói cách khác là biểu diễn 1 đối tượng dưới dạng String, ở đây chính là [text]
	 * Và đối tượng DI thật sự sẽ được nhận từ phương thức setValue của PropertyEditorCustomDate
	 * Phương thức setAsText để nhận giá trị từ file cấu hình bean
	 * Trong file cấu hình spring có key là class được biểu diễn dưới dạng String, và value 
	 * là class con của PropertyEditor
	 */
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub

		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setValue(date);
	}

	
}
