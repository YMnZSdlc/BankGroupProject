package pl.sda.commons;

import pl.sda.commons.services.CsvDocument;
import pl.sda.commons.services.ExcelDocument;
import pl.sda.commons.services.PdfDocument;
import pl.sda.commons.services.XmlDocument;

import static pl.sda.commons.DocumentType.*;

public class ConvertObjectToFile {

    private ConvertToFile convertToFile;

    public ConvertObjectToFile(DocumentType typ) {
        if (EXCEL.equals(typ)) {
            convertToFile = new ExcelDocument();
        } else if (CSV.equals(typ)) {
            convertToFile = new CsvDocument();
        } else if (PDF.equals(typ)) {
            convertToFile = new PdfDocument();
        } else if (XML.equals(typ)) {
            convertToFile = new XmlDocument();
        }
    }

    public boolean convert(Object object) {
       return convertToFile.convert(object);
    }
}
