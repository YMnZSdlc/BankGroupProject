package pl.sda;

public enum  DocumentType {

    PDF(".pdf"), EXCEL(".xls"), CSV(".csv"), XML(".xml");

    private String name;

    DocumentType(String name) {
        this.name = name;
    }
}
