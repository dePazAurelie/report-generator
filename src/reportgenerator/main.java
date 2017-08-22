package reportgenerator;
 
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.IOException;
 
public class main {
 
    public static void main(String args[]) throws FileNotFoundException {
    	PdfWriter writer = new PdfWriter("hello_world.pdf");
    	PdfDocument pdf = new PdfDocument(writer);
    	Document document = new Document(pdf);
    	document.add(new Paragraph("Hello World!"));
    	document.close();
    }
}