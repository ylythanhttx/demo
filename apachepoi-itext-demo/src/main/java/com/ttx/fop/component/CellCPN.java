package com.ttx.fop.component;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class CellCPN implements FoCPN {

	private String xml;

	public CellCPN() {
		this.xml = "<fo:table-cell>"
				+ "</fo:table-cell>";
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
