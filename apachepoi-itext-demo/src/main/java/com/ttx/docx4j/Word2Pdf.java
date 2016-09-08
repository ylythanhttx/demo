package com.ttx.docx4j;

public class Word2Pdf {
	public static void main(String[] args) {
        try {
             
           /* long start = System.currentTimeMillis();
            PhysicalFonts.setRegex(".*"); 
            InputStream is = new FileInputStream(
                    new File("C:/Users/android/Documents/E-Com" + "/TIFF-5.docx"));
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                    .load(is);
            List sections = wordMLPackage.getDocumentModel().getSections();
            for (int i = 0; i < sections.size(); i++) {
 
                System.out.println("sections Size" + sections.size());
                wordMLPackage.getDocumentModel().getSections().get(i)
                        .getPageDimensions().setHeaderExtent(3000);
            }
            Mapper fontMapper = new IdentityPlusMapper();
 
            PhysicalFont font = PhysicalFonts.getPhysicalFonts().get(
                    "Arial");
 
            fontMapper.getFontMappings().put("Algerian", font);
 
            wordMLPackage.setFontMapper(fontMapper);
            PdfSettings pdfSettings = new PdfSettings();
            org.docx4j.convert.out.pdf.PdfConversion conversion = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(
                    wordMLPackage);
            
            ((org.docx4j.convert.out.pdf.viaXSLFO.Conversion) conversion).setSaveFO(new java.io.File("C:/Users/android/Documents/E-Com" + "/TIFF-5.docx" + ".fo"));
 
            OutputStream out = new FileOutputStream(new File(
            		"C:/Users/android/Documents/E-Com" + "/TIFF-5-OUT.pdf"));
            conversion.output(out, pdfSettings);
            System.err.println("Time taken to Generate pdf  "
                    + (System.currentTimeMillis() - start) + "ms");*/
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}