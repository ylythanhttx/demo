package com.ttx.apachepoidemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/**
 * Hello world!
 *
 * <pre>
 * 
 * #Symbol trong word Chinh la ki tu dat biet trong java Character 
 * Ex: System.out.println(new Character((char) 9668).toString());
 * Tuong ung voi font system, va  Decima code trong phan insert 
 * Symbol trong word
 * Ex: Ki tu la bai bich (♠) = new Character((char) 9824).toString();
 * la code Decima 9824 font Arial Linux (Ubuntu)
 * 
 * #To replace symbol:
 * 1 Cell co 1 hoac nhieu paragraph (thuong chi co 1),
 * 1 paragraph thuong co nhieu run [List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();]
 * Tuong ung voi moi run thi getText -> cac chuoi, trong do co symbol
 * Ex: Gia su symbol (♠) tai paragraphs[0] va xwpfRuns[1] 
 * cell.getParagraphs().get(0).getRuns().get(1).setText(new Character((char) 8597).toString(), 0);
 * 
 * Thread.currentThread().getContextClassLoader().getResource("") -> folder root project
 * (inside root is java package. ex com.xxx)
 * 
 * com.ttx.apachepoidemo.App.class.getResource("").toURI() -> parent path of Class App
 * To get path: File file = new File(App.class.getResource("").toURI());
 * String path = file.getPath() (ex: D:\Developer\MyGit\demo\apachepoi-itext-demo\target\classes\com\ttx\apachepoidemo)
 * 
 * </pre>
 *
 */
public class App {

	static List<Map<String, Object>> styleRow = null;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, XmlException, URISyntaxException {

		String path = new File(App.class.getResource("").toURI()).getPath();

		System.out.println(new Character((char) 9824).toString());
		System.out.println(new Character((char) 9744).toString());
		System.out.println(new Character((char) 9745).toString());
		System.out.println(new Character((char) 9660).toString());
		System.out.println(new Character((char) 61608).toString());

		FileInputStream fis = new FileInputStream("C:/Users/android/Documents/E-Com" + "/TIF-1.docx");
		XWPFDocument document = new XWPFDocument(fis);

		List<IBodyElement> lst = document.getBodyElements();

		for (int i = 0; i < lst.size(); i++) {
			IBodyElement element = lst.get(i);
			if (element instanceof XWPFParagraph) {
				/*XWPFParagraph paragraph = (XWPFParagraph) element;

				XWPFRun xwpfRun = paragraph.getRuns().get(0);
				CTR ctr = xwpfRun.getCTR() ;
//				ctr.set(arg0)
				if (paragraph.getText().contains("Phone")) {
					replaceTextInParagrap(paragraph, "Phone", "VLLLLL");
				}*/
			} else {
				XWPFTable xwpfTable = (XWPFTable) element;
				boolean[] as = new boolean[] { true, true, false, true, false };
				int x = 0;
				parent: for (int ii = 0; ii < xwpfTable.getRows().size(); ii++) {

					for (int j = 0; j < xwpfTable.getRows().get(ii).getTableCells().size(); j++) {

						if (xwpfTable.getRows().get(ii).getTableCells().get(j).getText().contains("Không")
								&& xwpfTable.getRows().get(ii).getTableCells().get(j).getText().contains("Có")) {
							// System.out.println(cell.getParagraphs().get(0).getRuns().size());
							XWPFRun run = xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0)
									.getRuns().get(0);
							System.out.println("code: "+WordUtils.findCharCodeSymbolInXWPFRun(run));
							System.out.println("font: "+WordUtils.findFontNameSymbolInXWPFRun(run));
							WordUtils.replaceCharCodeSymbolInXWPFRun(run, "00ED");
							xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0);
							run.getText(0);
							/*
							 * System.out.println(run.getCTR()); SchemaType
							 * schemaType = run.getCTR().schemaType(); CTRImpl
							 * ctrImpl = new CTRImpl(schemaType);
							 * System.out.println(ctrImpl); XWPFRun xwpfRun =
							 * null; String xml = run.getCTR().toString();
							 * xwpfRun.getCTR().set(XmlObject.Factory.parse(xml)
							 * );
							 */
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();

							String xml = " <xml-fragment w:rsidRPr=\"000D46AC\" xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\"> "
									+ "  <w:rPr> " + "  <w:rFonts w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:cs=\"Arial\"/> "
									+ "  <w:sz w:val=\"24\"/> " + " <w:szCs w:val=\"24\"/> "
									+ " <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FDE9D9\" w:themeFill=\"accent6\" w:themeFillTint=\"33\"/> "
									+ " </w:rPr> " + " <w:sym w:font=\"Wingdings\" w:char=\"00D7\"/> "
									+ " </xml-fragment> ";
							String xml1 = " <xml-fragment w:rsidRPr=\"000D46AC\" xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\"> "
									+ " <w:sym w:font=\"Wingdings\" w:char=\"00D7\"/> " + " </xml-fragment> ";

							// Char code hexa in font wingding symbol word
							String xml2 = " <xml-fragment w:rsidRPr=\"000D46AC\" "
									+ "xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" "
									+ "xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" "
									+ "xmlns:o=\"urn:schemas-microsoft-com:office:office\" "
									+ "xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" "
									+ "xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" "
									+ "xmlns:v=\"urn:schemas-microsoft-com:vml\" "
									+ "xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" "
									+ "xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" "
									+ "xmlns:w10=\"urn:schemas-microsoft-com:office:word\" "
									+ "xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" "
									+ "xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" "
									+ "xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" "
									+ "xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" "
									+ "xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" "
									+ "xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\"> "
									+ " <w:sym w:font=\"Wingdings\" w:char=\"0026\"/> " + " </xml-fragment> ";

							System.out.println(XmlObject.Factory.parse(run.getCTR().toString()));
							// run.getCTR().set(XmlObject.Factory.parse(run.getCTR().toString()));
							// run.getCTR().set(XmlObject.Factory.parse("<xml-fragment
							// />"));
//							run.getCTR().set(XmlObject.Factory.parse(xml));
//							run.getCTR().set(XmlObject.Factory.parse(xml2));
							if (xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0).getRuns()
									.size() > 1) {
								if (as[ii - 1]) {
									x++;
									xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0)
											.removeRun(0);
									xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0)
											.removeRun(5);
								} else {
									xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0)
											.removeRun(1);
									xwpfTable.getRows().get(ii).getTableCells().get(j).getParagraphs().get(0)
											.removeRun(4);
								}
							}
							// break parent;
						}
					}
				}
			}
		}
		FileOutputStream fos = new FileOutputStream("C:/Users/android/Documents/E-Com" + "/TIF-1-OUT.docx");
		document.write(fos);
		fos.close();

	}

	// Template has defalut one row (template row)
	// template row is row in template
	@SuppressWarnings("deprecation")
	static Map<String, Object> styleRowCell(XWPFTableCell cellTemplate) {

		XWPFParagraph paragraphTemplate = cellTemplate.getParagraphs().get(0);
		XWPFRun xwpfRunTemplate = paragraphTemplate.getRuns().get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Bold", xwpfRunTemplate.isBold());
		map.put("Color", xwpfRunTemplate.getColor());
		map.put("FontFamily", xwpfRunTemplate.getFontFamily());
		map.put("FontSize", xwpfRunTemplate.getFontSize());
		map.put("Italic", xwpfRunTemplate.isItalic());
		map.put("Strike", xwpfRunTemplate.isStrike());
		map.put("Subscript", xwpfRunTemplate.getSubscript());
		map.put("Underline", xwpfRunTemplate.getUnderline());
		map.put("TextPosition", xwpfRunTemplate.getTextPosition());
		return map;
	}

	static List<Map<String, Object>> styleRow(XWPFTableRow rowTemplate) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<XWPFTableCell> xwpfTableCells = rowTemplate.getTableCells();
		if (xwpfTableCells != null) {

			for (XWPFTableCell cellTemplate : xwpfTableCells) {
				Map<String, Object> map = styleRowCell(cellTemplate);
				list.add(map);
			}
		}

		return list;
	}

	/**
	 * <pre>
	 * Deprecated: because:
	 * replace string in cell, but string = many XWPFRun in cell
	 * so can string not in one XWPFRun.
	 * => Replace in XWPFRun
	 * </pre>
	 * 
	 * Word document bao gom List<IBodyElement> IBodyElement -> [XWPFParagraph]
	 * | [XWPFTable]
	 * 
	 * @param xwpfParagraph
	 *            ~ 1 Vung trong file word
	 * @param oldChar
	 * @param newChar
	 */
	@Deprecated
	static void replaceTextInParagrap(XWPFParagraph xwpfParagraph, String oldChar, String newChar) {

		if (xwpfParagraph == null) {
			return;
		}
		List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();
		if (xwpfRuns != null) {
			for (XWPFRun xwpfRun : xwpfRuns) {

				String text = xwpfRun.getText(0);
				if (text != null && text.contains(oldChar)) {
					text = text.replace(oldChar, newChar);
					xwpfRun.setText(text, 0);
				}
			}
		}
	}

	// Using replace text in cell
	/**
	 * <pre>
	 * Deprecated: because:
	 * replace string in cell, but string = many XWPFRun in cell
	 * so can string not in one XWPFRun.
	 * => Replace in XWPFRun
	 * </pre>
	 * 
	 * @param tableCell
	 * @param oldChar
	 * @param newChar
	 */
	@Deprecated
	static void replaceTextInCellTable(XWPFTableCell tableCell, String oldChar, String newChar) {

		List<XWPFParagraph> xwpfParagraphs = tableCell.getParagraphs();
		if (xwpfParagraphs != null) {
			for (XWPFParagraph xwpfParagraph : xwpfParagraphs) {
				replaceTextInParagrap(xwpfParagraph, oldChar, newChar);
			}
		}
	}

	// Using remove template row
	/**
	 * delete add position
	 * 
	 * @param xwpfTable
	 * @param position
	 */
	static void deleteRowInTable(XWPFTable xwpfTable, int position) {

		if (xwpfTable != null) {
			final int size = xwpfTable.getRows().size();
			while (((xwpfTable.getRows().size() >= size)) && (xwpfTable.getRows().size() > position)) {
				xwpfTable.removeRow(position);
			}
		}
	}

	/**
	 * delete all row
	 * 
	 * @param xwpfTable
	 */
	// Using remove all row
	static void deleteRowInTable(XWPFTable xwpfTable) {

		while (xwpfTable.getRows().size() > 0) {
			xwpfTable.removeRow(0);
		}
	}

	/**
	 * delete from-to
	 * 
	 * @param xwpfTable
	 * @param firstIndex
	 * @param lastIndex
	 */
	static void deleteRowInTable(XWPFTable xwpfTable, int firstIndex, int lastIndex) {

		if (lastIndex < firstIndex) {
			deleteRowInTable(xwpfTable, firstIndex);
		} else if (lastIndex >= firstIndex) {

			final int size = xwpfTable.getRows().size();
			if (lastIndex >= size) {
				lastIndex = size - 1;
			}
			while (((xwpfTable.getRows().size() - firstIndex) >= (size - lastIndex))
					&& (xwpfTable.getRows().size() > firstIndex)) {
				xwpfTable.removeRow(firstIndex);
			}
		} else {
			throw new RuntimeException();
		}

	}

	// after table remove template row
	/**
	 * 
	 * @param xwpfTable
	 * @param args
	 *            ~ List tham so cho 1 row
	 */
	static void addNewRowInToTable(XWPFTable xwpfTable, String... args) {

		XWPFTableRow row = xwpfTable.createRow();
		for (int i = 0; i < styleRow.size(); i++) {

			XWPFTableCell cell = null;
			XWPFParagraph paragraph = null;
			XWPFRun xwpfRun = null;
			if (i == 0) {
				try {
					cell = row.getCell(0);
					if (cell == null) {
						cell = row.addNewTableCell();
					}
				} catch (Exception e) {
				}
			} else {
				cell = row.getCell(i);
				if (cell == null) {
					cell = row.addNewTableCell();
				}
			}
			paragraph = cell.addParagraph();
			paragraph.setBorderTop(Borders.BASIC_THIN_LINES);
			paragraph.setBorderLeft(Borders.BASIC_THIN_LINES);
			paragraph.setBorderRight(Borders.DOUBLE_D);
			paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			xwpfRun = paragraph.createRun();

			xwpfRun.setBold((Boolean) styleRow.get(i).get("Bold"));
			// xwpfRun.setColor((String) styleRow.get(i).get("Color"));
			xwpfRun.setFontFamily((String) styleRow.get(i).get("FontFamily"));
			xwpfRun.setFontSize((Integer) styleRow.get(i).get("FontSize"));
			xwpfRun.setItalic((Boolean) styleRow.get(i).get("Italic"));
			// xwpfRun.setStrike((Boolean) styleRow.get(i).get("Strike"));
			// xwpfRun.setSubscript((VerticalAlign)
			// styleRow.get(i).get("Subscript"));
			xwpfRun.setUnderline((UnderlinePatterns) styleRow.get(i).get("Underline"));
			// xwpfRun.setUnderline(UnderlinePatterns.SINGLE);

			CTTc ctTc = cell.getCTTc();
			// Add new border
			CTTcPr tcPr = ctTc.addNewTcPr();
			// Edit border
			// CTTcPr tcPr = ctTc.getTcPr();
			CTTcBorders border = tcPr.addNewTcBorders();

			border.addNewBottom().setVal(STBorder.SINGLE);
			border.addNewRight().setVal(STBorder.SINGLE);
			border.addNewLeft().setVal(STBorder.SINGLE);
			border.addNewTop().setVal(STBorder.SINGLE);

			try {
				xwpfRun.setText(args[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void word2PDF(InputStream is, OutputStream os) {
		try {
			// 1) Load DOCX into XWPFDocument
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			PdfConverter.getInstance().convert(document, os, options);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	static void word2PDF(XWPFDocument document, OutputStream os) {
		try {

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			PdfConverter.getInstance().convert(document, os, options);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	static void word2HTML(InputStream is, OutputStream os) {
		try {

			XWPFDocument document = new XWPFDocument(is);
			// 2) Prepare Html options
			XHTMLOptions options = XHTMLOptions.create();

			// 3) Convert XWPFDocument to HTML
			XHTMLConverter.getInstance().convert(document, os, options);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	static void word2HTML(XWPFDocument document, OutputStream os) {
		try {
			// 2) Prepare Html options
			XHTMLOptions options = XHTMLOptions.create();

			// 3) Convert XWPFDocument to HTML
			XHTMLConverter.getInstance().convert(document, os, options);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
