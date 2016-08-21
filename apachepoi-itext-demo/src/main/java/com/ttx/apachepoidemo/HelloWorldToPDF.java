package com.ttx.apachepoidemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.itextpdf.xmp.impl.Utils;

public class HelloWorldToPDF {

	public static void main(String[] args) throws Exception {
//		createPDF();
		createTable();
	}

	private static void createPDF() {
		try {
			long start = System.currentTimeMillis();

			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream("/home/thanh/Documents/Unit2.docx");
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			 PdfOptions options = PdfOptions.create();
//			 options.fontEncoding("UTF-8");

			// 3) Convert XWPFDocument to Pdf
			OutputStream out = new FileOutputStream("/home/thanh/Documents/Unitf.pdf");
			PdfConverter.getInstance().convert(document, out, options);

			System.err.println("Generate pdf/HelloWorld.pdf with " + (System.currentTimeMillis() - start) + "ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static void createTable() throws Exception
	{
	    // The path to the documents directory.
	    String dataDir = "/home/thanh/Documents/Unit2.docx";

	    XWPFDocument document = new XWPFDocument();

	    // New 2x2 table
	    XWPFTable tableOne = document.createTable(3,3);
	    tableOne.setWidth(50);
	    XWPFTableRow tableRowThree = tableOne.createRow();
	    tableRowThree.getCell(0).setText("col one, row three");
	    tableRowThree.getCell(1).setText("col two, row three");
	    tableRowThree.getCell(2).setText("col three, row three");
	    // Add a break between the tables
//	    document.createParagraph().createRun().addBreak();

	    
	    FileOutputStream outStream = new FileOutputStream(dataDir + "Apache_CreateTable.doc");
	    document.write(outStream);
	    outStream.close();
	}
}