import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.Cell;

import java.io.FileOutputStream;
import java.util.Date;

public class Main {
    private static String FILE = "C:/Users/LENOVO/Desktop/Te_PDF.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();


            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        document.add(preface);
        document.newPage();
    }
    private static void addContent(Document document) throws DocumentException {
        Anchor anchor = new Anchor("Resume", catFont);
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        createTable(catPart);
        document.add(catPart);

    }

    private static void createTable(Chapter catPart)
            throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{3, 3});
        table.addCell("name");
        table.addCell("Dawid");
        table.addCell("last name");
        table.addCell("Durołek");
        table.addCell("education");
        table.addCell("2018 - 2021 pwsz Tarnów");
        table.addCell("Summary");
        table.addCell("                                         ");
        catPart.add(table);
    }


    }
