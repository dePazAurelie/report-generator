package reportgenerator;
 
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.FileNotFoundException;
 
public class main {

    public static void main(String args[]) throws FileNotFoundException {
    	PdfWriter writer = new PdfWriter("hello_world.pdf");
    	PdfDocument pdf = new PdfDocument(writer);
    	DocumentPDF document = new DocumentPDF(pdf);
    }
}