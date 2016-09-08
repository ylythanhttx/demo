package com.ttx.fop.component;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public interface FoCPN {

	FoCPN addParagraph(FoCPN parent, XWPFParagraph paragraph);
	
	FoCPN addTable(FoCPN parent, XWPFTable table);
}
