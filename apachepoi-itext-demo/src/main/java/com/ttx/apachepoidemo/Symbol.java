package com.ttx.apachepoidemo;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

/**
 * 
 * 
 * <pre>
 *   
 *   With apache poi
 *   -- Word document: new XWPFDocument(fis);
 *      IBodyElement -> [XWPFParagraph | XWPFTable]
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
 *                     See word file open by winrra|&zip and find
 *            -- XWPFPicture
 *   One unit display in word ~ XmlObject
 *   Ex: 
 *   XmlObject xmlObject = XmlObject.Factory.parse(xml);
 *   XWPFRun xwpfRun = paragraph.getRuns().get(0);
 *	 CTR ctr = xwpfRun.getCTR() ;
 *	 ctr.set(xmlObject);
 *   ctr.toString() -> xml
 *   
 *   String xml = 
 *      " <xml-fragment w:rsidRPr=\"000D46AC\" "
 *		+ "xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" "
 *		+ "xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" "
 *		+ "xmlns:o=\"urn:schemas-microsoft-com:office:office\" "
 *		+ "xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" "
 *		+ "xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" "
 *		+ "xmlns:v=\"urn:schemas-microsoft-com:vml\" "
 *		+ "xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" "
 *		+ "xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" "
 *		+ "xmlns:w10=\"urn:schemas-microsoft-com:office:word\" "
 *		+ "xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" "
 *		+ "xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" "
 *		+ "xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" "
 *		+ "xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" "
 *		+ "xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" "
 *		+ "xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\"> "
 *		+ "<w:sym w:font=\"Wingdings\" w:char=\"0026\"/> " 
 *      + "</xml-fragment> ";
 * 
 * </pre>
 * 
 * @author thanh
 */
public class Symbol {

	/**
	 * <pre>
	 * CHECKBOX_TRUE_WINGDINGS
	 * font: Wingdings
	 * hexaCode:00FE
	 * </pre>
	 */
	public static final XmlObject CHECKBOX_TRUE_WINGDINGS = getSymbol("Wingdings", "00FE");

	/**
	 * <pre>
	 * CHECKBOX_FALSE_WINGDINGS
	 * font: Wingdings
	 * hexaCode:00A8
	 * </pre>
	 */
	public static final XmlObject CHECKBOX_FALSE_WINGDINGS = getSymbol("Wingdings", "00A8");

	/**
	 * <pre>
	 * hexaCode: cod hexa of symbol word
	 * fontName: font system. Ex wingdings
	 * </pre>
	 * 
	 * @param hexaCode
	 * @param fontName
	 * @return
	 *
	 */
	static XmlObject getSymbol(String fontName, String hexaCode) {

		String xml = " <xml-fragment w:rsidRPr=\"000D46AC\" "
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
				+ " <w:sym w:font=\"" + fontName + "\" w:char=\"" + hexaCode + "\"/> " + " </xml-fragment> ";
		try {
			return XmlObject.Factory.parse(xml);
		} catch (XmlException e) {
			e.printStackTrace();
			try {
				return XmlObject.Factory.parse("<xml-fragment />");
			} catch (XmlException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}
}
