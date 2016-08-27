package com.ttx.apachepoidemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum;

/**
 * <pre>
 * APACHE POI WORD
 *      -- Word document: new XWPFDocument(fis);
 *         IBodyElement -> [XWPFParagraph | XWPFTable]
 *   	-- XWPFTable:
 *         [XWPFTableRow] 
 *         -- XWPFTableRow
 *         	  [XWPFTableCell]
 *         	  -- XWPFTableCell		 
 *         		 [XWPFParagraph]
 *      -- XWPFParagraph
 *         [XWPFRun]
 *         -- XWPFRun
 *         	  CTR | [XWPFPicture]  
 *         	  -- CTR
 *               XmlObject
 *               -- XmlObject
 *                  String xml | File | InputStream ...
 *                  -- String xml
 *                     See word file open by winrra|7zip and find
 *            -- XWPFPicture
 * </pre>
 * 
 * @author thanh
 *
 */
public class WordUtils {

	public static enum Style {

		Bold, Color, FontFamily, FontSize, Italic, Subscript, Underline, TextPosition, TopBorder, BottomBorder, RightBorder, LeftBorder
	}

	/**
	 * 
	 * <pre>
	 *  -- XWPFParagraph -> [XWPFRun]
	 *  -- XWPFRun.setText(text) -> add text
	 *  -- XWPFRun.setText(text, 0) -> set text
	 * </pre>
	 * 
	 * @param xwpfParagraph
	 * @param text
	 */
	public static void setTextInToXWPFParagraph(XWPFParagraph xwpfParagraph, String text) {

		while (xwpfParagraph.getRuns().size() > 1) {
			xwpfParagraph.removeRun(0);
		}
		XWPFRun xwpfRun = null;
		if (xwpfParagraph.getRuns() == null || xwpfParagraph.getRuns().size() == 0) {
			xwpfRun = xwpfParagraph.createRun();
			xwpfRun.setText(text, 0);
		} else {
			xwpfParagraph.getRuns().get(0).setText(text, 0);
		}
	}

	/**
	 * --Work OK
	 * 
	 * <pre>
	 * XWPFTableCell -> [XWPFParagraph]. (normal one XWPFParagraph)
	 * </pre>
	 * 
	 * @param xwpfTableCell
	 * @param text
	 * @see #setTextInToXWPFParagraph(XWPFParagraph, String)
	 */
	public static void setTextInToXWPFTableCell(XWPFTableCell xwpfTableCell, String text) {

		while (xwpfTableCell.getParagraphs().size() > 1) {
			xwpfTableCell.removeParagraph(0);
		}
		setTextInToXWPFParagraph(xwpfTableCell.getParagraphs().get(0), text);
	}

	/**
	 * Thay thế các chuỗi được đánh dấu trong các cell table
	 * regex: ngăn cách giữa key và value.
	 * ex proposalNo::180000000 -> [\\:]{2}
	 * 
	 * @param xwpfTable
	 * @param strings
	 */
	public static void replaceTextInUniqueXWPFTable(XWPFTable xwpfTable, String regex, String... strings) {

		for (String str : strings) {
			if (str != null && str.matches(".*" + regex + ".*")) {
				String key = str.split(regex)[0];
				String value = str.split(regex)[1];
				for (XWPFTableRow xwpfTableRow : xwpfTable.getRows()) {
					for (XWPFTableCell xwpfTableCell : xwpfTableRow.getTableCells()) {
						if (xwpfTableCell.getText().trim().equals(key.trim())) {
							WordUtils.setTextInToXWPFTableCell(xwpfTableCell, value);
						}
					}
				}
			}
		}
	}

	/**
	 * --Work OK
	 * 
	 * <pre>
	 *  require symbol and unique in Run
	 * </pre>
	 * 
	 * @param xwpfRun
	 * @return hexa code
	 */
	public static String findCharCodeSymbolInXWPFRun(XWPFRun xwpfRun) {

		String xml = xwpfRun.getCTR().toString();
		xml = getStringMatchRegex(xml, "w\\:char=\"[A-F0-9]{1,}\"");
		xml = xml.replaceAll("(w\\:char=\")|(\")", "");
		return xml;
	}

	/**
	 * --Work OK
	 * 
	 * <pre>
	 *  require symbol and unique in Run
	 * </pre>
	 * 
	 * @param xwpfRun
	 * @param newCharCode
	 * @throws XmlException
	 */
	public static void replaceCharCodeSymbolInXWPFRun(XWPFRun xwpfRun, String newCharCode) throws XmlException {

		String oldCharCode = findCharCodeSymbolInXWPFRun(xwpfRun);
		String xml = xwpfRun.getCTR().toString();
		xml = xml.replace("w:char=\"" + oldCharCode + "\"", "w:char=\"" + newCharCode + "\"");
		xwpfRun.getCTR().set(XmlObject.Factory.parse(xml));
	}

	/**
	 * --Work OK
	 * 
	 * <pre>
	 *  require symbol and unique in XWPFRun
	 * </pre>
	 * 
	 * @param xwpfRun
	 * @return hexa code
	 */
	public static String findFontNameSymbolInXWPFRun(XWPFRun xwpfRun) {

		String xml = xwpfRun.getCTR().toString();
		xml = getStringMatchRegex(xml, "w\\:font=\"[a-zA-Z0-9\\s]{1,}\"");
		xml = xml.replaceAll("(w\\:font=\")|(\")", "");
		return xml;
	}

	/**
	 * <pre>
	 *  
	 * reqire unique table with args
	 * if >1 table with args -> return first table 
	 * args: some text in table
	 * </pre>
	 * 
	 * @param xwpfDocument
	 * @param args
	 * @return
	 */
	public static XWPFTable detectXWPFTable(XWPFDocument xwpfDocument, String... args) {

		List<IBodyElement> iBodyElements = xwpfDocument.getBodyElements();
		for (IBodyElement bodyElement : iBodyElements) {

			if (bodyElement instanceof XWPFTable) {
				XWPFTable xwpfTable = (XWPFTable) bodyElement;
				if (args == null) {
					return xwpfTable;
				}
				int countContains = 0;
				String tableContent = xwpfTable.getText();
				for (int i = 0; i < args.length; i++) {

					if (tableContent.contains(args[i])) {
						countContains++;
					}
				}
				if (countContains == (args.length)) {
					return xwpfTable;
				}
			}
		}
		return null;
	}

	/**
	 * <pre>
	 *  
	 * reqire unique row with args
	 * if >1 row with args -> return first row 
	 * args: some text in row
	 * </pre>
	 * 
	 * @param xwpfTable
	 * @param args
	 * @return
	 */
	public static XWPFTableRow detectXWPFTableRow(XWPFTable xwpfTable, String... args) {

		List<XWPFTableRow> xwpfTableRows = xwpfTable.getRows();
		for (XWPFTableRow xwpfTableRow : xwpfTableRows) {

			if (args == null) {
				return xwpfTableRow;
			}
			int countContains = 0;
			String rowContent = "";
			for (XWPFTableCell xwpfTableCell : xwpfTableRow.getTableCells()) {
				rowContent = rowContent + xwpfTableCell.getText();
			}
			for (int i = 0; i < args.length; i++) {

				if (rowContent.contains(args[i])) {
					countContains++;
				}
			}
			if (countContains == (args.length)) {
				return xwpfTableRow;
			}
		}
		return null;
	}

	/**
	 * <pre>
	 * Style: font, size ...
	 * xwpfRun: from template row word
	 * </pre>
	 * 
	 * @param xwpfParagraph
	 * @return
	 * @see #addListDataToXWPFTable(XWPFTable, List, int, int...)
	 */

	@Deprecated
	static Map<Style, Object> getStyleInXWPFRun(XWPFRun xwpfRun) {

		Map<Style, Object> map = new HashMap<Style, Object>();
		map.put(Style.Bold, xwpfRun.isBold());
		map.put(Style.Color, xwpfRun.getColor());
		map.put(Style.FontFamily, xwpfRun.getFontFamily());
		map.put(Style.FontSize, xwpfRun.getFontSize());
		map.put(Style.Italic, xwpfRun.isItalic());
		map.put(Style.Subscript, xwpfRun.getSubscript());
		map.put(Style.Underline, xwpfRun.getUnderline());
		map.put(Style.TextPosition, xwpfRun.getTextPosition());
		return map;
	}

	/**
	 * <pre>
	 * font size, border
	 * </pre>
	 * 
	 * @param xwpfTableCell
	 * @return
	 * @see #addListDataToXWPFTable(XWPFTable, List, int, int...)
	 * 
	 */
	@Deprecated
	static Map<Style, Object> getStyleInxwpfTableCell(XWPFTableCell xwpfTableCell) {

		Map<Style, Object> map = new HashMap<Style, Object>();
		for (XWPFRun xwpfRun : xwpfTableCell.getParagraphs().get(0).getRuns()) {

			if (xwpfRun.getText(0) == null) {
				continue;
			}
			map = getStyleInXWPFRun(xwpfRun);
			break;
		}

		try {
			map.put(Style.TopBorder, xwpfTableCell.getCTTc().getTcPr().getTcBorders().getTop().getVal());
		} catch (Exception e) {
			map.put(Style.TopBorder, STBorder.SINGLE);
		}
		try {
			map.put(Style.BottomBorder, xwpfTableCell.getCTTc().getTcPr().getTcBorders().getBottom().getVal());
		} catch (Exception e) {
			map.put(Style.BottomBorder, STBorder.SINGLE);
		}
		try {
			map.put(Style.RightBorder, xwpfTableCell.getCTTc().getTcPr().getTcBorders().getRight().getVal());
		} catch (Exception e) {
			map.put(Style.RightBorder, STBorder.SINGLE);
		}

		try {
			map.put(Style.LeftBorder, xwpfTableCell.getCTTc().getTcPr().getTcBorders().getLeft().getVal());
		} catch (Exception e) {
			map.put(Style.LeftBorder, STBorder.SINGLE);
		}

		return map;
	}

	/**
	 * <pre>
	 * Yêu cầu: các cột trong table có cùng style
	 * args : text tương ứng các cột
	 * style: có thể được lấy từ 1 cell mẫu
	 * columns: số cột
	 * nếu start và end = -1 -> tạo 1 dòng bên dưới cùng
	 * </pre>
	 * 
	 * @param xwpfTable
	 * @param args
	 * @throws XmlException
	 * @Deprecated {@link #addListDataToXWPFTable(XWPFTable, List, int, int)}
	 * @See {@link #addListDataToXWPFTable(XWPFTable, List, int, int)}
	 */
	@Deprecated
	static void addNewRowInToXWPFTable(XWPFTable xwpfTable, Map<Style, Object> style, int columns, int pos,
			String... args) throws XmlException {

		XWPFTableRow xwpfTableRow = null;

		if (pos == -1) {
			xwpfTableRow = xwpfTable.createRow();
		} else {
			xwpfTableRow = xwpfTable.insertNewTableRow(pos);
		}
		for (int i = 0; i < columns; i++) {
			XWPFTableCell xwpfTableCell = null;
			XWPFParagraph paragraph = null;
			if (i == 0) {
				try {
					xwpfTableCell = xwpfTableRow.getCell(0);
					if (xwpfTableCell == null) {
						xwpfTableCell = xwpfTableRow.addNewTableCell();
					}
				} catch (Exception e) {
				}
			} else {
				xwpfTableCell = xwpfTableRow.addNewTableCell();
			}
			paragraph = xwpfTableCell.addParagraph();
			XWPFRun xwpfRun = paragraph.createRun();

			xwpfRun.setBold((Boolean) style.get(Style.Bold));
			xwpfRun.setColor((String) style.get(Style.Color));
			xwpfRun.setFontFamily((String) style.get(Style.FontFamily));
			xwpfRun.setFontSize((Integer) style.get(Style.FontSize));
			xwpfRun.setItalic((Boolean) style.get(Style.Italic));

			CTTc ctTc = xwpfTableCell.getCTTc();
			CTTcPr tcPr = ctTc.addNewTcPr();
			CTTcBorders border = tcPr.addNewTcBorders();
			border.addNewBottom().setVal((Enum) style.get(Style.BottomBorder));
			border.addNewRight().setVal((Enum) style.get(Style.RightBorder));
			border.addNewLeft().setVal((Enum) style.get(Style.LeftBorder));
			border.addNewTop().setVal((Enum) style.get(Style.TopBorder));

			try {
				xwpfRun.setText(args[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * <pre>
	 *   index: những vị trí muốn xóa lúc đầu.
	 *   Sort tăng dần, mỗi lần xóa thì lần tiếp theo
	 *   sex giảm vị trí xóa xuống tương ứng số lẫn đã xóa
	 * </pre>
	 * 
	 * @param xwpfTable
	 * @param index
	 */
	public static void removeXWPFTableRow(XWPFTable xwpfTable, int... index) {

		for (int s = 0; s < index.length; s++) {
			for (int x = s + 1; x < index.length; x++) {
				int varS = index[s];
				int varX = index[x];
				if (index[s] > index[x]) {
					index[s] = varX;
					index[x] = varS;
				}
			}
		}
		for (int r = 0; r < index.length; r++) {
			xwpfTable.removeRow(index[r] - r);
		}
	}

	/**
	 * --Work OK
	 * 
	 * <pre>
	 * datas: dữ liệu cần đổ vào table
	 * Object[]: row data -> Object[i] cell data
	 * index: vị trí bắt đầu (ex: O là vị trí header)
	 * <h3>rowTemplate</h3>: là vị trí những dòng mẫu (font size ...)
	 * Cần xóa nó trước khi thêm dòng dữ liệu thật
	 * Trước khi xóa nó cần lấy xml của nó để dùng lại
	 * 
	 * Good code add new row clone style:
	 * String xml = xwpfTableRow.getCtRow().toString();
	 * CTRow row = xwpfTable.getCTTbl().insertNewTr(index);
	 * row.set(XmlObject.Factory.parse(xml));
	 * xwpfTable.getCTTbl().setTrArray(index, row);
	 * xwpfTable.getRows().add(index, new XWPFTableRow(row, xwpfTable));
	 * </pre>
	 * 
	 * @param xwpfTable
	 * @param datas
	 * @param index
	 * @param rowTemplate
	 * @throws XmlException
	 */
	public static void addListDataToXWPFTable(XWPFTable xwpfTable, int index, List<Object[]> datas, int... rowTemplate)
			throws XmlException {

		XWPFTableRow xwpfTableRow = xwpfTable.getRow(1);
		String xml = xwpfTableRow.getCtRow().toString();
		WordUtils.removeXWPFTableRow(xwpfTable, rowTemplate);

		int temp = 0;
		for (int i = 0; i < datas.size(); i++) {
			CTRow row = xwpfTable.getCTTbl().insertNewTr(index + temp);
			row.set(XmlObject.Factory.parse(xml));
			xwpfTable.getCTTbl().setTrArray(index + temp, row);
			XWPFTableRow tableRow = new XWPFTableRow(row, xwpfTable);
			xwpfTable.getRows().add(index + temp, tableRow);
			for (int x = 0; x < tableRow.getTableCells().size(); x++) {
				WordUtils.setTextInToXWPFTableCell(tableRow.getTableCells().get(x), datas.get(i)[x].toString());
			}
			temp++;
		}
	}

	/**
	 * --Work OK
	 * 
	 * @param input
	 * @param regex
	 *            require unique
	 * @return
	 */
	public static String getStringMatchRegex(String input, String regex) {

		String[] inputs = input.split(regex);
		for (int i = 0; i < inputs.length; i++) {
			input = input.replace(inputs[i], "");
		}
		return input;
	}

	public static void main(String[] args) {

		String xml = " <w:sym w:font=\"Wingdings\" w:char=\"0000\"/> " + " </xml-fragment> ";
		/*
		 * xml = getStringMatchRegex(xml, "w\\:font=\"[a-zA-Z0-9\\s]{1,}\"");
		 * xml = xml.replaceAll("(w\\:font=\")|(\")", "");
		 * System.out.println(xml);
		 */
		xml = xml.replace("w:char=\"" + "0000" + "\"", "w:char=\"" + "1111" + "\"");
		System.out.println(xml);
	}
}
