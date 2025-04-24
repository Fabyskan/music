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
        }; //Rückmapping von String zu Enum
        return value;
    }

    public static String getAbbreviation(NoteValue toAbbreviate) {
        String myString = switch (toAbbreviate) {
            case WHOLE: yield "W";
            case HALF: yield "H";
            case QUARTER: yield "Q";
            default: throw new IllegalArgumentException("Unknown note: " + toAbbreviate);
        };
        return myString;
    }
}

/**
 * Diese Klasse ist dafür da, um die Wertigkeit von Noten darstellen zu können. Wir beschränken uns hier auf Ganze,
 * Halbe und Viertel.
 * Das wird als Enum umgesetzt.
 * <p>
 *     Test kein Plan wozu das p ist.
 * </p>
 */