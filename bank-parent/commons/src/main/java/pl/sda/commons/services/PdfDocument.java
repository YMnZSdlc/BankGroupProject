package pl.sda.commons.services;

import pl.sda.Document;
import pl.sda.DocumentType;

public class PdfDocument extends Document {

    public PdfDocument(String text, DocumentType docType) {
        super(text, docType);
    }
}
