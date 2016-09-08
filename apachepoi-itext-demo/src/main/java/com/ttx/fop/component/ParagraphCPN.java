package com.ttx.fop.component;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class ParagraphCPN implements FoCPN {

	private String xml;

	public ParagraphCPN() {
		this.xml = "<block xmlns=\"http://www.w3.org/1999/XSL/Format\">"
				+ "</block>";
	}

	@Override
	public FoCPN addParagraph(FoCPN parent, XWPFParagraph paragraph) {
		return this;
	}

	@Override
	public FoCPN addTable(FoCPN parent, XWPFTable table) {
		return this;
	}

	@Override
	public String toString() {
		return xml;
	}
}
