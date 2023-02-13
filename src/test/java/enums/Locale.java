package enums;

public enum Locale {
    RU("Русский"),
    EN("English");

    private final String value;

    Locale(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
