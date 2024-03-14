package enums;

public enum Area {
    EURASIA("EURASIA"),
    AFRICA("AFRICA"),
    NORTH_AMERICA("NORTH_AMERICA"),
    SOUTH_AMERICA("SOUTH_AMERICA"),
    AUSTRALIA("AUSTRALIA"),
    ANTARCTICA("ANTARCTICA");



    private String value;

    Area(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
