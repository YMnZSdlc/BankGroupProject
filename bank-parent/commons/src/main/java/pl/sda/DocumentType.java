package pl.sda;

public enum  DocumentType {

    PDF(".pdf"), EXCEL(".xls"), CSV(".csv");

    private String name;

    DocumentType(String name) {
        this.name = name;
    }
}
