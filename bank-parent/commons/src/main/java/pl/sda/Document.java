package pl.sda;


public class Document {

    private String text;
    private DocumentType docType;

    public Document(String text, DocumentType docType) {
        this.text = text;
        this.docType = docType;
    }
}
