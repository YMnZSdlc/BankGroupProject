package pl.sda.commons.strategy;

import pl.sda.commons.services.CsvGenerator;
import pl.sda.commons.services.ExcelDocument;
import pl.sda.commons.services.PdfDocument;
import pl.sda.commons.services.XmlDocument;

import static pl.sda.commons.strategy.DocumentType.*;

public class ConvertObjectToFile {

    private Converatble converatble;

    public ConvertObjectToFile(DocumentType typ) {
        if (EXCEL.equals(typ)) {
            converatble = new ExcelDocument();
        } else if (CSV.equals(typ)) {
            converatble = new CsvGenerator();
        } else if (PDF.equals(typ)) {
            converatble = new PdfDocument();
        } else if (XML.equals(typ)) {
            converatble = new XmlDocument();
        }
    }

    public boolean convert(Object object) {
       return converatble.convert(object);
    }
}
