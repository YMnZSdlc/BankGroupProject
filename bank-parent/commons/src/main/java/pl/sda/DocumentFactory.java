package pl.sda;

public class DocumentFactory {

    public Document createDocument(String text, DocumentType docType) {


        if (docType.equals(DocumentType.EXCEL)) {

            return new ExcelDocument(text, docType);

        } else if (docType.equals(DocumentType.PDF)) {

            return new CsvDocument(text, docType);


        } else if (docType.equals(DocumentType.CSV)) {

            return new PdfDocument(text, docType);

        }

        return null; //FIXME 13.10.18
    }

}
