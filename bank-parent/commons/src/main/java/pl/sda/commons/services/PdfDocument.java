package pl.sda.commons.services;

import com.itextpdf.text.*;
import org.apache.log4j.Logger;
import pl.sda.commons.strategy.Convertable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Date;

import static com.itextpdf.text.BaseColor.BLACK;
import static com.itextpdf.text.FontFactory.COURIER;
import static com.itextpdf.text.FontFactory.getFont;
import static com.itextpdf.text.pdf.PdfWriter.getInstance;
import static org.apache.log4j.Logger.getLogger;
import static pl.sda.commons.tools.PathToFile.getPath;
import static pl.sda.commons.tools.ValidParameters.check;


public class PdfDocument implements Convertable {

    private static final String PATH = getPath();
    private static final Font FONT = getFont(COURIER, 11, BLACK);
    private static Logger LOGGER = getLogger(PdfDocument.class);

    @Override
    public boolean convert(Object data) {

        check(data, PATH);
        Document document = new Document();
        try {
            getInstance(document, new FileOutputStream(PATH));
        } catch (DocumentException | FileNotFoundException e) {
            LOGGER.error(e.toString());
        }
        document.open();
        boolean result = operationOnPdf(data, document);
        document.close();
        return result;
    }

    private boolean operationOnPdf(Object data, Document document) {
        boolean result = false;
        try {
            addTitlePage(document);
            if (java.util.List.class.isAssignableFrom(data.getClass())) {
                java.util.List list = (java.util.List) data;
                for (Object object : list) {
                    result = addContent(document, object);
                }
            } else {
                result = addContent(document, data);
            }
        } catch (DocumentException e) {
            LOGGER.error(e.toString());
        }
        document.close();
        return result;
    }

    private void addTitlePage(Document document)
            throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Title of the document", FONT));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                FONT));
        document.add(preface);
        document.newPage();
    }

    private boolean addContent(Document document, Object data) throws DocumentException {

        Anchor anchor = new Anchor(data.getClass().getSimpleName().toUpperCase(), FONT);
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        createList(catPart, data);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        return document.add(catPart);
    }

    private void createList(Chapter catPart, Object data) {

        List list = new List(true, false, 10);

        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                addNewItemToPdf(data, list, field);
            } catch (IllegalAccessException e) {
                LOGGER.error(e.toString());
            }
        }
        catPart.add(list);
    }

    private void addNewItemToPdf(Object data, List list, Field field) throws IllegalAccessException {
        if (field.get(data) != null) {
            if (java.util.List.class.isAssignableFrom(field.getType())) {
                Object objectWhereFieldsAreDaclared = field.get(data);
                java.util.List listOfObjects = (java.util.List) objectWhereFieldsAreDaclared;
                writeListOfObject(list, listOfObjects);

            } else {

                list.add(new ListItem(field.get(data).toString()));
            }
        }
    }

    private void writeListOfObject(List list, java.util.List listOfObjects) throws IllegalAccessException {
        for (Object objectFromList : listOfObjects) {
            if (objectFromList == null) {
                continue;
            }
            Field[] fields1 = objectFromList.getClass().getDeclaredFields();
            for (Field field1 : fields1) {
                if (field1 == null) {
                    continue;
                }
                field1.setAccessible(true);
                if (field1.get(objectFromList) == null) {
                    continue;
                }
                list.add(new ListItem(field1.get(objectFromList).toString()));
            }
        }
    }


    private void addEmptyLine(Paragraph paragraph, int number) {

        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
