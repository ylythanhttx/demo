package com.ttx.fop.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class TextCPN implements FoCPN {

	static final String FONT_FAMILY = " font-family";
	static final String FONT_SIZE = " font-size";
	static final String FONT_WEIGHT = "font-weight";
	static final String FONT_STYLE = "font-style";
	static final List<String> textStyle = new ArrayList<String>();
	static {
		textStyle.add(FONT_FAMILY);
		textStyle.add(FONT_SIZE);
		textStyle.add(FONT_WEIGHT);
		textStyle.add(FONT_WEIGHT);
	}
	private String xml;

	public TextCPN() {
		this.xml = "<inline>" + "</inline>";
	}

	@Override
	public FoCPN addParagraph(FoCPN parent, XWPFParagraph paragraph) {

		XWPFRun ctr = paragraph.getRuns().get(0);
		String begin = FOUtils.getStringMatchRegex(xml, "(<inline)(([^/])*)(>)");
		if (!begin.contains(FONT_FAMILY)) {
			begin = begin.substring(0, begin.length() - 1) + FONT_FAMILY + "=\"" + ctr.getFontFamily() + "\""
					+ begin.substring(begin.length() - 1);
		}
		if (!begin.contains(FONT_SIZE)) {
			begin = begin.substring(0, begin.length() - 1) + FONT_SIZE + "=\"" + ctr.getFontSize() + "\""
					+ begin.substring(begin.length() - 1);
		}

		if (!begin.contains(FONT_WEIGHT) && ctr.isBold()) {
			begin = begin.substring(0, begin.length() - 1) + FONT_WEIGHT + "=\"bold\""
					+ begin.substring(begin.length() - 1);
		}
		if (!begin.contains(FONT_STYLE) && ctr.isItalic()) {
			begin = begin.substring(0, begin.length() - 1) + FONT_STYLE + "=\"italic\""
					+ begin.substring(begin.length() - 1);
		}

		String end = FOUtils.getStringMatchRegex(xml, "</inline>");
		xml = begin + "\n" + paragraph.getText() + "\n" + end;
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

	public static void main(String[] args) {
		TextCPN textCPN = new TextCPN();
//		String begin = FOUtils.getStringMatchRegex(textCPN.toString(), "(<inline)(^(/)*)(>)");
//		begin = begin.substring(0, begin.length() - 1) + FONT_FAMILY + "=\"Arial\""
//				+ begin.substring(begin.length() - 1);
//		String end = FOUtils.getStringMatchRegex(textCPN.toString(), "</inline>");
//		System.out.println(begin);
		System.out.println("123".matches("^.(94)"));
	}
}
