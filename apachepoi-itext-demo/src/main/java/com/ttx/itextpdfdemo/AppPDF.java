package com.ttx.itextpdfdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class AppPDF {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("/home/thanh/Documents/Unit.pdf");
		PdfReader pdfReader = new PdfReader(fis);
		PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("D:\\ModifiedTestFile.pdf"));
		Document document = new Document();

		// Get the number of pages in pdf.
		int pages = pdfReader.getNumberOfPages();
		// Iterate the pdf through pages.
		for (int i = 1; i <= pages; i++) {
			// Contain the pdf data.
			PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
			

		}
		document.open();
	}

}
