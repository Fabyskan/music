public enum NoteValue {
    WHOLE("W"),
    HALF("H"),
    QUARTER("Q");

    private final String abbreviation;

    /**
     * Konstruktor für die Notenwerte
     * @param abbreviation Abkürzung als String
     */
    NoteValue(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Parse Funktion um Strings in Notenwerte umzuwandeln
     * @param abbreviation Abkürzung für den Notenwert
     * @return Notenwert
     */
    public static NoteValue parse(String abbreviation) {
        NoteValue value = switch (abbreviation) {
            case "W": yield WHOLE;
            case "H": yield HALF;
            case "Q": yield QUARTER;
            default: throw new IllegalArgumentException("Unknown abbreviation: " + abbreviation);
        }; //Rückmapping von String zu Enum
        return value;
    }

    /**
     * Getter für die Abkürzung
     * @return Gibt die Abkürzung aus
     */
    public String getAbbreviation() {
       /* String myString = switch (toAbbreviate) {
            case WHOLE: yield "W";
            case HALF: yield "H";
            case QUARTER: yield "Q";
            default: throw new IllegalArgumentException("Unknown note: " + toAbbreviate);
        };
        return myString; */
        return abbreviation;
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