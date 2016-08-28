package com.ttx.itextpdfdemo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
//JAXP
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
// FOP
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToFoConverter;
import org.apache.poi.hwpf.converter.WordToFoUtils;
import org.apache.poi.util.XMLHelper;

/**
 * https://technology.amis.nl/2006/03/22/converting-word-documents-to-xsl-fo-and
 * -onwards-to-pdf/ http://www.ibm.com/developerworks/library/x-xstrmfo/
 * http://xmlgraphics.apache.org/fop/fo.html
 * https://msdn.microsoft.com/en-us/library/aa203691.aspx Docx stylesheet:
 * https://msdn.microsoft.com/en-us/library/ee872374(v=office.12).aspx
 * 
 * @author android
 *
 */
public class AppPDF {

	public static void main(String[] args) throws Exception {

		 getFoText("C:/Users/android/Documents/E-Com/TIFF-2.doc");
//		convertFO2PDF(new File("D:\\Developer\\STSs\\workspaces\\w1\\doc4j-demo\\file\\out\\TIFF-5-OUT.fo"),
//				new File(System.getProperty("user.dir") + "/file/out/a.pdf"));
	}

	public static void convertFO2PDF(File fo, File pdf) throws IOException, FOPException {

		OutputStream out = null;

		try {
			out = new FileOutputStream(pdf);
			out = new BufferedOutputStream(out);
			FopFactory foFactory = FopFactory.newInstance(new File(".").toURI());
			Fop fop = foFactory.newFop((MimeConstants.MIME_PDF), foFactory.newFOUserAgent(), out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			Source src = new StreamSource(fo);
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(src, res);
			/*
			 * FormattingResults foResults = fop.getResults(); List
			 * pageSequences = foResults.getPageSequences(); for (Iterator it =
			 * pageSequences.iterator(); it.hasNext();) { PageSequenceResults
			 * pageSequenceResults = (PageSequenceResults) it.next(); System.out
			 * .println("PageSequence " +
			 * (String.valueOf(pageSequenceResults.getID()).length() > 0 ?
			 * pageSequenceResults.getID() : "  id") + " generated " +
			 * pageSequenceResults.getPageCount() + " pages."); }
			 * System.out.println("Generated " + foResults.getPageCount() +
			 * " pages in total.");
			 */

		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		} finally {
			out.close();
		}
	}

	static String getFoText(final String sampleFileName) throws Exception {
		HWPFDocumentCore hwpfDocument = WordToFoUtils.loadDoc(new File(sampleFileName));

		WordToFoConverter wordToFoConverter = new WordToFoConverter(
				XMLHelper.getDocumentBuilderFactory().newDocumentBuilder().newDocument());
		wordToFoConverter.processDocument(hwpfDocument);

		StringWriter stringWriter = new StringWriter();

		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		foUserAgent.setProducer(AppPDF.class.getName());
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent,
				new FileOutputStream(System.getProperty("user.dir") + "/file/out/a.pdf"));
		Result res = new SAXResult(fop.getDefaultHandler());

		// Template <fo:>
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer(new StreamSource(new File("C:/Users/android/Documents/E-Com/Word2FO.xsl")));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		// transformer.setOutputProperty(OutputKeys.METHOD, "xml-fo");
		// arg[1] data binding template fo
		transformer.transform(new StreamSource(new File("C:/Users/android/Documents/E-Com/TIFF-5-2003.xml")), res);
		/*
		 * transformer.transform( new StreamSource(new
		 * File("C:/Users/android/Documents/E-Com/document.xslt")), new
		 * StreamResult(new FileOutputStream(
		 * "D:\\Developer\\STSs\\workspaces\\w1\\doc4j-demo\\file\\out\\TIFF-5-OUT.fo"
		 * )));
		 */

		String result = stringWriter.toString();
		return result;
	}
}
