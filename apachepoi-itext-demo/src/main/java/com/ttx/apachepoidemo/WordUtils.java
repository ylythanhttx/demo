package com.ttx.apachepoidemo;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

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
		xwpfParagraph.getRuns().get(0).setText(text, 0);
	}

	/**
	 * --Work OK
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
	 * --Work OK
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
		xml = xml.replace("w:char=\""+oldCharCode+"\"", "w:char=\""+newCharCode+"\"");
		xwpfRun.getCTR().set(XmlObject.Factory.parse(xml));
	}
	
	/**
	 * --Work OK
	 * <pre>
	 *  require symbol and unique in Run
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
	 * --Work OK
	 * @param input
	 * @param regex require unique
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
		/*xml = getStringMatchRegex(xml, "w\\:font=\"[a-zA-Z0-9\\s]{1,}\"");
		xml = xml.replaceAll("(w\\:font=\")|(\")", "");
		System.out.println(xml);*/
		xml = xml.replace("w:char=\""+"0000"+"\"", "w:char=\""+"1111"+"\"");
		System.out.println(xml);
	}
}
