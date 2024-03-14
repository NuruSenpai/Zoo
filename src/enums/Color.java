package enums;

public enum Color {
    BLACK("BLACK"),
    GRAY("GRAY"),
    YELLOW("YELLOW"),
    WHITE("WHITE");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

