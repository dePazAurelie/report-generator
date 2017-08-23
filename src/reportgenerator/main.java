package reportgenerator;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import reportgenerator.pdfManager.linker;
import reportgenerator.pdflayout.pageLayout;

public class main {

	public static void main(String[] args) {
		try {
			String FILE = "c:/Users/Aurélie de Paz/Desktop/report-generator/test.pdf";
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			document = pageLayout.initDocument(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}