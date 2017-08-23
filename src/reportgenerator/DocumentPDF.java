package reportgenerator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


public class DocumentPDF {
    Document document;
    PdfDocument pdf;

    public DocumentPDF(PdfDocument pdf) {
        this.pdf = pdf;
        initDocument();
    }

    public void initDocument() {
        Document document = new Document(pdf);
        document.add(new Paragraph("Bonjour!"));
        document.close();
    }
}
