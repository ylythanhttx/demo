package com.ttx.fop.component;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class RootFoCPN implements FoCPN {

	private String xml;

	public RootFoCPN() {
		this.xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> "
				+ "<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\"> " + "</fo:root>";
	}

	@Override
	public String toString() {
		return xml;
	}

	@Override
	public FoCPN addParagraph(FoCPN parent, XWPFParagraph paragraph) {

		return this;
	}

	@Override
	public FoCPN addTable(FoCPN parent, XWPFTable table) {

		return this;
	}
}
