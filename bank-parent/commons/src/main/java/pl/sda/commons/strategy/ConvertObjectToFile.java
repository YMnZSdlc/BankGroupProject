package pl.sda.commons.strategy;

import pl.sda.commons.exceptions.ObjectToSaveInvalid;
import pl.sda.commons.services.CsvGenerator;
import pl.sda.commons.services.ExcelDocument;
import pl.sda.commons.services.PdfDocument;
import pl.sda.commons.services.XmlDocument;

import static pl.sda.commons.strategy.DocumentType.*;

public class ConvertObjectToFile {

    private Convertable convertable;

    public ConvertObjectToFile(DocumentType typ) {
        if (EXCEL.equals(typ)) {
            convertable = new ExcelDocument();
        } else if (CSV.equals(typ)) {
            convertable = new CsvGenerator();
        } else if (PDF.equals(typ)) {
            convertable = new PdfDocument();
        } else if (XML.equals(typ)) {
            convertable = new XmlDocument();
        } else {
            throw new ObjectToSaveInvalid("Invalid Type");
        }
    }

    public boolean convert(Object object) {
        return convertable.convert(object);
    }
}
