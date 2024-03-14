package enums;

public enum Type {
    BEAR("bear"),
    KANGAROO("kangaroo"),
    PENGUIN("penguin"),
    TIGER("tiger"),
    WOLF("wolf");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
