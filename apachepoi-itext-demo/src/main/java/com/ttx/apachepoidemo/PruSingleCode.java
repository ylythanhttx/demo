package com.ttx.apachepoidemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

public class PruSingleCode {

	public static void main(String[] args) throws Exception {

		InputStream inputStream = getData("TLA3");
		System.out.println(inputStream);
	}

	static File getTemplateFile(String componentCode) throws Exception, Exception {
		if ("EUS4".equals(componentCode) || "TLA3".equals(componentCode)) {
			return new File(App.class.getResource("TIFF-5.docx").toURI());
		} else if ("ROP1".equals(componentCode)) {
			return new File(App.class.getResource("TIFF-2.docx").toURI());
		}
		return new File(App.class.getResource("TIFF-0.docx").toURI());
	}

	public static InputStream getData(String componentCode) throws Exception {
		FileInputStream fis = new FileInputStream(getTemplateFile(componentCode));
		XWPFDocument document = new XWPFDocument(fis);

		// Proposal
		XWPFTable xwpfTableProposal = detectXWPFTable(document, "HSYCBH số", "Hợp đồng số", "Lập ngày");
		replaceTextInUniqueXWPFTable(xwpfTableProposal, "[\\:]{2}", "<proposal no>::1800000000",
				"<policy no>::12345678", "<payment dd/mm/yyyy hh:mm>::12-12-2012");

		// Customer
		boolean gender = true;
		boolean isMarri = false;
		boolean isTaxUs = false;
		XWPFTable xwpfTableCustomer = detectXWPFTable(document, "Họ và tên", "Giới tính", "Số CMND", "Quốc tịch",
				"Địa chỉ liên lạc", "Điện thoại di động", "Nghề nghiệp", "Tình trạng gia đình");
		replaceTextInUniqueXWPFTable(xwpfTableCustomer, "[\\:]{2}", "<Capital letter>::Nguyen Trung",
				"<Ngày sinh>::12-12-2012", "<Nơi sinh>::Hồ Chí Minh", "<Số CMND>::215000000", "<Ngày cấp>::12-12-2012",
				"<Nơi cấp>::Hồ Chí Minh", "<Quốc tịch>::Việt Nam", "<Đường/số nhà>::123 Nguyễn Thị Bưởi",
				"<Phường/xã>::Phường 7", "<Quận/huyện>::Quận 7", "<Thành phố/Tỉnh>::Hồ Chí Minh",
				"<Điện thoại di động>::0123456789", "<Địa chỉ email>::a@123.com", "<Nghề nghiệp>::Lập trình viên",
				"<Nhóm nghề>::IT", "<cm>::160 cm", "<Kg>::52 Kg");
		XWPFTableRow tableRowGender = detectXWPFTableRow(xwpfTableCustomer, "Giới tính", "Ngày sinh");
		for (XWPFTableCell tableCell : tableRowGender.getTableCells()) {
			if (tableCell.getText().contains("Nam") && tableCell.getText().contains("Nữ")) {
				int count = 0;
				for (XWPFRun xwpfRun : tableCell.getParagraphs().get(0).getRuns()) {
					String charCode = findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (gender) {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					} else if ((count == 2)) {
						if (gender) {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					}
				}
			}

		}
		XWPFTableRow tableRowMarri = detectXWPFTableRow(xwpfTableCustomer, "Đã lập gia đình", "Tình trạng gia đình");
		for (XWPFTableCell tableCell : tableRowMarri.getTableCells()) {
			if (tableCell.getText().contains("Độc thân") && tableCell.getText().contains("Đã lập gia đình")) {
				int count = 0;
				for (XWPFRun xwpfRun : tableCell.getParagraphs().get(0).getRuns()) {
					String charCode = findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (isMarri) {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					} else if ((count == 2)) {
						if (isMarri) {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					}
				}
			}

		}
		XWPFTableRow tableRowTaxUS = detectXWPFTableRow(xwpfTableCustomer,
				"Hiện Quý khách có khai báo thuế tại Hoa Kỳ hay không?");
		for (XWPFTableCell tableCell : tableRowTaxUS.getTableCells()) {
			if (tableCell.getText().contains("Có") && tableCell.getText().contains("Không")) {
				int count = 0;
				for (XWPFRun xwpfRun : tableCell.getParagraphs().get(0).getRuns()) {
					String charCode = findCharCodeSymbolInXWPFRun(xwpfRun);
					if (charCode == null || "".equals(charCode)) {
						continue;
					}
					count++;
					if (count == 1) {
						if (isTaxUs) {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						} else {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						}
					} else if ((count == 2)) {
						if (isTaxUs) {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
						} else {
							replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
						}
					}
				}
			}

		}

		// System.out.println(xwpfTableCustomer.getText());
		// Table component
		XWPFTable xwpfTableComponent = detectXWPFTable(document, "Loại hình bảo hiểm", "Số tiền bảo hiểm",
				"Thời hạn bảo hiểm", "Thời hạn đóng phí");
		Object[] objs1 = new Object[] { "1", "2", "3", "4" };
		List<Object[]> objects = Arrays.asList(objs1, objs1, objs1, objs1, objs1, objs1, objs1, objs1, objs1);
		addListDataToXWPFTable(xwpfTableComponent, 1, objects, 1, 3, 2);

		// Beninfo
		XWPFTable xwpfTableBenInfo = detectXWPFTable(document, "Họ và tên", "Giới tính", "Quan hệ với NĐBH",
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
		addListDataToXWPFTable(xwpfTableBenInfo, 1, bens, 1, 3, 2, 4);

		// QuestionNaire
		// 00A8 = false
		// 00FE = true
		if ("ESU4".equals(componentCode) || "TLA3".equals(componentCode) || "ROP1".equals(componentCode)) {
			XWPFTable xwpfTableQuestion = detectXWPFTable(document, "Câu hỏi", "Trả lời", "Không", "Có");
			List<Boolean> as = null;
			if ("ROP1".equals(componentCode)) {
				as = Arrays.asList(true, false);
			} else {
				as = Arrays.asList(true, false, false, true, true);
			}
			for (int i = 1; i < xwpfTableQuestion.getRows().size(); i++) {
				boolean rs = as.get(i - 1);
				for (int j = 0; j < xwpfTableQuestion.getRows().get(i).getTableCells().size(); j++) {
					XWPFTableCell xwpfTableCell = xwpfTableQuestion.getRows().get(i).getTableCells().get(j);
					int count = 0;
					for (XWPFRun xwpfRun : xwpfTableCell.getParagraphs().get(0).getRuns()) {
						String charCode = findCharCodeSymbolInXWPFRun(xwpfRun);
						if (charCode == null || "".equals(charCode)) {
							continue;
						}
						count++;
						if (count == 1) {
							if (rs) {
								replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
							} else {
								replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
							}
						} else if ((count == 2)) {
							if (rs) {
								replaceCharCodeSymbolInXWPFRun(xwpfRun, "00A8");
							} else {
								replaceCharCodeSymbolInXWPFRun(xwpfRun, "00FE");
							}
						}
					}
				}
			}
		}
		File fileOUT = null;
		if ("ROP1".equals(componentCode)) {
			fileOUT = new File(System.getProperty("user.dir") + "/file/out/TIFF-2-OUT.docx");
		} else if ("EUS4".equals(componentCode) || "TLA3".equals(componentCode)) {
			fileOUT = new File(System.getProperty("user.dir") + "/file/out/TIFF-5-OUT.docx");
		} else {
			fileOUT = new File(System.getProperty("user.dir") + "/file/out/TIFF-0-OUT.docx");
		}
		if (fileOUT.exists()) {
			fileOUT.delete();

		}
		fileOUT.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileOUT);
		document.write(fos);
		fos.close();
		return new FileInputStream(fileOUT);

	}

	static void replaceCharCodeSymbolInXWPFRun(XWPFRun xwpfRun, String newCharCode) throws XmlException {

		String oldCharCode = findCharCodeSymbolInXWPFRun(xwpfRun);
		String xml = xwpfRun.getCTR().toString();
		xml = xml.replace("w:char=\"" + oldCharCode + "\"", "w:char=\"" + newCharCode + "\"");
		xwpfRun.getCTR().set(XmlObject.Factory.parse(xml));
	}

	static String findCharCodeSymbolInXWPFRun(XWPFRun xwpfRun) {

		String xml = xwpfRun.getCTR().toString();
		xml = getStringMatchRegex(xml, "w\\:char=\"[A-F0-9]{1,}\"");
		xml = xml.replaceAll("(w\\:char=\")|(\")", "");
		return xml;
	}

	static String findFontNameSymbolInXWPFRun(XWPFRun xwpfRun) {

		String xml = xwpfRun.getCTR().toString();
		xml = getStringMatchRegex(xml, "w\\:font=\"[a-zA-Z0-9\\s]{1,}\"");
		xml = xml.replaceAll("(w\\:font=\")|(\")", "");
		return xml;
	}

	static String getStringMatchRegex(String input, String regex) {

		String[] inputs = input.split(regex);
		for (int i = 0; i < inputs.length; i++) {
			input = input.replace(inputs[i], "");
		}
		return input;
	}

	static void replaceTextInUniqueXWPFTable(XWPFTable xwpfTable, String regex, String... strings) {

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

	static XWPFTable detectXWPFTable(XWPFDocument xwpfDocument, String... args) {

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

	static void addListDataToXWPFTable(XWPFTable xwpfTable, int index, List<Object[]> datas, int... rowTemplate)
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

	static XWPFTableRow detectXWPFTableRow(XWPFTable xwpfTable, String... args) {

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
}
