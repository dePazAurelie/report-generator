package reportgenerator.pdflayout;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.Date;
import static com.itextpdf.text.Rectangle.NO_BORDER;

public class pageLayout {

    public static Document initDocument(Document document) {
        try {
            addTitlePage(document);
            addPeople(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    private static void addPeople(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Presents :", smallBold));
        cell.setPadding(10f);
        cell.setPaddingLeft(5f);
        cell.setBorder(NO_BORDER);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Excused :", smallBold));
        cell.setPadding(5f);
        cell.setBorder(NO_BORDER);
        cell.setRowspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Valentin", classic));
        cell.setPadding(5f);
        cell.setBorder(NO_BORDER);
        cell.setRowspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Charles", classic));
        cell.setPadding(5f);
        cell.setBorder(NO_BORDER);
        cell.setRowspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Aurélie", classic));
        cell.setBorder(NO_BORDER);
        cell.setPadding(5f);
        cell.setRowspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Cécile", classic));
        cell.setBorder(NO_BORDER);
        cell.setPadding(5f);
        cell.setRowspan(1);
        table.addCell(cell);
        document.add(table);
    }

    private static void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Nom du projet, numéro du projet", titleFont));
        addEmptyLine(preface, 1);

        preface.add(new Paragraph("Sous-titre", subFont));
        addEmptyLine(preface, 1);

        preface.add(new Paragraph("Host : " + System.getProperty("user.name"), smallBold));
        preface.add(new Paragraph( "E-mail : ", smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Date : "+ new Date(), classic));
       // preface.add(new Paragraph("Durée : ", classic)); V2
       // preface.add(new Paragraph("Lieu : ", classic)); V2
        addEmptyLine(preface, 2);
        document.add(preface);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
             paragraph.add(new Paragraph(" "));
        }
    }

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
    private static Font classic = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);


    public pageLayout(Document document) {
        initDocument(document);
    }
}