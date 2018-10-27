package pl.sda.commons;

import pl.sda.commons.services.CsvDocument;
import pl.sda.commons.services.ExcelDocument;
import pl.sda.commons.services.PdfDocument;
import pl.sda.commons.services.XmlDocument;

public class ConvertObjectToFile {

    private DocumentType typ;
    private ConvertToFile convertToFile;

    public ConvertObjectToFile(DocumentType typ) {

        if (typ.equals(DocumentType.EXCEL)) {

            convertToFile = new ExcelDocument();
        } else if (typ.equals(DocumentType.CSV)) {
            convertToFile = new CsvDocument();
        } else if (typ.equals(DocumentType.PDF)) {
            convertToFile = new PdfDocument();
        } else if (typ.equals(DocumentType.XML)) {
            convertToFile = new XmlDocument();
        }
    }

    public void convert(Object object) {

        convertToFile.convert(object);
    }
}
