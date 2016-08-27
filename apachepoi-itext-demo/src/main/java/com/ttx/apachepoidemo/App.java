package com.ttx.apachepoidemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;

/**
 * Hello world!
 *
 * <pre>
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

	public static void main(String[] args) throws IOException, XmlException, URISyntaxException {

		FileInputStream fis = new FileInputStream(new File(App.class.getResource("TIFF-5.docx").toURI()));
		XWPFDocument document = new XWPFDocument(fis);

		// Proposal
		XWPFTable xwpfTableProposal = WordUtils.detectXWPFTable(document, "HSYCBH số", "Hợp đồng số", "Lập ngày");
		WordUtils.replaceTextInUniqueXWPFTable(xwpfTableProposal, "[\\:]{2}", "<proposal no>::1800000000",
				"<policy no>::12345678", "<payment dd/mm/yyyy hh:mm>::12-12-2012");

		// Customer
		boolean gender = true;
		boolean isMarri = false;
		boolean isTaxUs = false;
		XWPFTable xwpfTableCustomer = WordUtils.detectXWPFTable(document, "Họ và tên", "Giới tính", "Số CMND",
				"Quốc tịch", "Địa chỉ liên lạc", "Điện thoại di động", "Nghề nghiệp", "Tình trạng gia đình");
		WordUtils.replaceTextInUniqueXWPFTable(xwpfTableCustomer, "[\\:]{2}", "<Capital letter>::Nguyen Trung",
				"<Ngày sinh>::12-12-2012", "<Nơi sinh>::Hồ Chí Minh", "<Số CMND>::215000000", "<Ngày cấp>::12-12-2012",
				"<Nơi cấp>::Hồ Chí Minh", "<Quốc tịch>::Việt Nam", "<Đường/số nhà>::123 Nguyễn Thị Bưởi",
				"<Phường/xã>::Phường 7", "<Quận/huyện>::Quận 7", "<Thành phố/Tỉnh>::Hồ Chí Minh",
				"<Điện thoại di động>::0123456789", "<Địa chỉ email>::a@123.com", "<Nghề nghiệp>::Lập trình viên",
				"<Nhóm nghề>::IT", "<cm>::160 cm", "<Kg>::52 Kg");
		XWPFTableRow tableRowGender = WordUtils.detectXWPFTableRow(xwpfTableCustomer, "Giới tính", "Ngày sinh");
		for (XWPFTableCell tableCell : tableRowGender.getTableCells()) {
			if (tableCell.getText().contains("Nam") && tableCell.getText().contains("Nữ")) {
				int count = 0;
				for (XWPFRun xwpfRun : tableCell.getParagraphs().get(0).getRuns()) {
					String charCode = WordUtils.findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (gender) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					} else if ((count == 2)) {
						if (gender) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					}
				}
			}

		}
		XWPFTableRow tableRowMarri = WordUtils.detectXWPFTableRow(xwpfTableCustomer, "Đã lập gia đình",
				"Tình trạng gia đình");
		for (XWPFTableCell tableCell : tableRowMarri.getTableCells()) {
			if (tableCell.getText().contains("Độc thân") && tableCell.getText().contains("Đã lập gia đình")) {
				int count = 0;
				for (XWPFRun xwpfRun : tableCell.getParagraphs().get(0).getRuns()) {
					String charCode = WordUtils.findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (isMarri) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					} else if ((count == 2)) {
						if (isMarri) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					}
				}
			}

		}
		XWPFTableRow tableRowTaxUS = WordUtils.detectXWPFTableRow(xwpfTableCustomer,
				"Hiện Quý khách có khai báo thuế tại Hoa Kỳ hay không?");
		for (XWPFTableCell tableCell : tableRowTaxUS.getTableCells()) {
			if (tableCell.getText().contains("Có") && tableCell.getText().contains("Không")) {
				int count = 0;
				for (XWPFRun xwpfRun : tableCell.getParagraphs().get(0).getRuns()) {
					String charCode = WordUtils.findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (isTaxUs) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					} else if ((count == 2)) {
						if (isTaxUs) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					}
				}
			}

		}

		// System.out.println(xwpfTableCustomer.getText());
		// Table component
		XWPFTable xwpfTableComponent = WordUtils.detectXWPFTable(document, "Loại hình bảo hiểm", "Số tiền bảo hiểm",
				"Thời hạn bảo hiểm", "Thời hạn đóng phí");
		Object[] objs1 = new Object[] { "1", "2", "3", "4" };
		List<Object[]> objects = Arrays.asList(objs1, objs1, objs1, objs1, objs1, objs1, objs1, objs1, objs1);
		WordUtils.addListDataToXWPFTable(xwpfTableComponent, 1, objects, 1, 3, 2);

		// Beninfo
		XWPFTable xwpfTableBenInfo = WordUtils.detectXWPFTable(document, "Họ và tên", "Giới tính", "Quan hệ với NĐBH",
				"Số CMND /Khai sinh", "Ngày sinh", "Quốc tịch", "% thụ hưởng");
		Object[] ben1 = new Object[] { "1", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben2 = new Object[] { "2", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben3 = new Object[] { "3", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben4 = new Object[] { "4", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben5 = new Object[] { "5", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben6 = new Object[] { "6", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben7 = new Object[] { "7", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben8 = new Object[] { "8", "2", "3", "4", "5", "6", "7", "8" };
		Object[] ben9 = new Object[] { "9", "2", "3", "4", "5", "6", "7", "8" };
		List<Object[]> bens = Arrays.asList(ben1, ben2, ben3, ben4, ben5, ben6, ben7, ben8, ben9);
		WordUtils.addListDataToXWPFTable(xwpfTableBenInfo, 1, bens, 1, 3, 2, 4);

		// QuestionNaire
		// 00A8 = false
		// 00FE = true
		XWPFTable xwpfTableQuestion = WordUtils.detectXWPFTable(document, "Câu hỏi", "Trả lời", "Không", "Có");
		List<Boolean> as = Arrays.asList(true, false, false, true, true);
		for (int i = 1; i < xwpfTableQuestion.getRows().size(); i++) {
			boolean rs = as.get(i - 1);
			for (int j = 0; j < xwpfTableQuestion.getRows().get(i).getTableCells().size(); j++) {
				XWPFTableCell xwpfTableCell = xwpfTableQuestion.getRows().get(i).getTableCells().get(j);
				int count = 0;
				for (XWPFRun xwpfRun : xwpfTableCell.getParagraphs().get(0).getRuns()) {
					String charCode = WordUtils.findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (rs) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					} else if ((count == 2)) {
						if (rs) {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							WordUtils.replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					}
				}
			}
		}
		File fileOUT = new File(System.getProperty("user.dir")+"/file/out/TIFF-5-OUT.docx");
		if (fileOUT.exists()) {
			fileOUT.delete();
			
		}
		fileOUT.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileOUT);
		document.write(fos);
		fos.close();

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
