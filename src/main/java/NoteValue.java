public enum NoteValue {
    WHOLE("W"),
    HALF("H"),
    QUARTER("Q");

    private final String abbreviation;

    NoteValue(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static NoteValue fromAbbreviation(String abbreviation) {
        NoteValue value = switch (abbreviation) {
            case "W": yield WHOLE;
            case "H": yield HALF;
            case "Q": yield QUARTER;
            default: throw new IllegalArgumentException("Unknown abbreviation: " + abbreviation);
        };
        return value;
    }
}
