package com.ttx.fop.component;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class TableCPN implements FoCPN {

	private String xml;

	public TableCPN() {
		this.xml = "<fo:table>"
				+ "<fo:table-body>"
				+ "</fo:table-body>"
				+ "</fo:table>";
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
