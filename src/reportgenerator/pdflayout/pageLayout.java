package reportgenerator.pdflayout;
import com.itextpdf.text.pdf.draw.LineSeparator;
import reportgenerator.pdfManager.linker;

import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import static com.itextpdf.text.Rectangle.NO_BORDER;

public class pageLayout {

    private Document initDocument(Document document, linker link) {
        try {
            addTitlePage(document, link);
            addPeople(document, link);
            addTopics(document, link);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }


    private void addTopics (Document document, linker link) throws DocumentException {
        Paragraph empty = new Paragraph();
        addEmptyLine(empty, 1);
        document.add(empty);
        Paragraph sectionTitle = new Paragraph("Topics :", subFont);
        addLineSeparator(sectionTitle);
        document.add(sectionTitle);
/*
        for (int i = 0 ; i < link.getTopics().size() ; i++) {
            Paragraph topic = new Paragraph();
            topic.add(new Paragraph(link.getTopics().get(i).getTopic(), smallBold));
            topic.add(new Paragraph(link.getTopics().get(i).getDecision(), classic));
            topic.add(new Paragraph(link.getTopics().get(i).getOutcome(), classicRed));
            addEmptyLine(topic, 1);
            document.add(topic);
        }*/
    }

    private void addPeople(Document document, linker link) throws DocumentException {

        Paragraph sectionTitle = new Paragraph("Attendees :", subFont);
        addLineSeparator(sectionTitle);
        document.add(sectionTitle);

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

        for (int i = 0 ; i < link.getAttendees().size() ; i++) {
            cell = new PdfPCell(new Phrase(link.getAttendees().get(i).getFirstName() + " "
                    + link.getAttendees().get(i).getLastName() + "\n" + link.getAttendees().get(i).getMail() + "\n"
                    , classic));
            cell.setPadding(5f);
            cell.setPaddingBottom(10f);
            cell.setBorder(NO_BORDER);
            cell.setRowspan(1);
            table.addCell(cell);
        }
        document.add(table);
    }

    private void addTitlePage(Document document, linker link) throws DocumentException {
        Paragraph header = new Paragraph();

        Paragraph title = new Paragraph(link.getProjectName(), titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        header.add(title);

        Paragraph number = new Paragraph("meeting n°" + link.getMeetingNumber(), smallBold);
        number.setAlignment(Element.ALIGN_CENTER);
        header.add(number);

        addEmptyLine(header, 1);
        header.add(new Paragraph("Sous-titre", subFont));
        addEmptyLine(header, 1);

        Phrase phrase = new Phrase();
        phrase.add(new Chunk("Host : ",smallBold));
        phrase.add(new Chunk(link.getHost().getFirstName() + " " + link.getHost().getLastName() + "\n", classic));
        header.add(phrase);

        phrase.clear();
        phrase.add(new Chunk("E-mail : ",smallBold));
        phrase.add(new Chunk(link.getHost().getMail() + "\n", classic));
        header.add(phrase);

        phrase.clear();
        phrase.add(new Chunk("Date : ",smallBold));
        phrase.add(new Chunk(link.getDate(), classic));
        header.add(phrase);

       // header.add(new Paragraph("Durée : ", classic)); V2
       // header.add(new Paragraph("Lieu : ", classic)); V2
        addEmptyLine(header, 1);
        document.add(header);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
             paragraph.add(new Paragraph(" "));
        }
    }

    private void addLineSeparator(Paragraph paragraph) {
        LineSeparator line = new LineSeparator();
        line.setOffset(-10f);
        paragraph.add(line);
        addEmptyLine(paragraph, 1);
    }

    private static Font titleFont = new Font(Font.FontFamily.HELVETICA, 24, Font.NORMAL);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
    private static Font classic = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
    private static Font classicRed = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);


    public pageLayout(linker link) {
        try {
            String FILE = "c:/Users/Aurélie de Paz/Desktop/report-generator/test.pdf";
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document = initDocument(document, link);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}