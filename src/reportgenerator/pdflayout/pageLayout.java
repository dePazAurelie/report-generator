package reportgenerator.pdflayout;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.Date;

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

        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(1);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        document.add(table);
    }

    private static void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Nom du projet, numéro du projet", titleFont));
        addEmptyLine(preface, 1);

        preface.add(new Paragraph("Sous-titre", subFont));
        addEmptyLine(preface, 1);

        preface.add(new Paragraph("Organisateur : " + System.getProperty("user.name"), smallBold));
        preface.add(new Paragraph( "email", smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Date : "+ new Date(), smallBold));
        preface.add(new Paragraph("Durée : ", smallBold));
        preface.add(new Paragraph("Lieu : ", smallBold));
        addEmptyLine(preface, 4);
        document.add(preface);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
             paragraph.add(new Paragraph(" "));
        }
    }

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);


    public pageLayout(Document document) {
        initDocument(document);
    }
}