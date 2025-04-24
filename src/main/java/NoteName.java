public enum NoteName {
    A("A"),
    A_SHARP("A#"),
    B("B"),
    C("C"),
    C_SHARP("C#"),
    D("D"),
    D_SHARP("D#"),
    E("E"),
    F("F"),
    F_SHARP("F#"),
    G("G"),
    G_SHARP("G#");

    private final String abbreviation;

    private NoteName(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static NoteName fromAbbreviation(String abbreviation) {
        NoteName name = switch (abbreviation) {
            case "A": yield A;
            case "A#": yield A_SHARP;
            case "B": yield B;
            case "C": yield C;
            case "C#": yield C_SHARP;
            case "D": yield D;
            case "D#": yield D_SHARP;
            case "E": yield E;
            case "F": yield F;
            case "F#": yield F_SHARP;
            case "G": yield G;
            case "G#": yield G_SHARP;
            default: throw new IllegalArgumentException("Unknown abbreviation: " + abbreviation);
        }; //Rückmapping der Notennamen String zu Enum
        return name;
    }

    public static String getAbbreviation(NoteName toAbbreviate) {
        String myString = switch (toAbbreviate) {
            case A: yield "A";
            case A_SHARP: yield "A#";
            case B: yield "B";
            case C: yield "C";
            case C_SHARP: yield "C#";
            case D: yield "D";
            case D_SHARP: yield "D#";
            case E: yield "E";
            case F: yield "F";
            case F_SHARP: yield "F#";
            case G: yield "G";
            case G_SHARP: yield "G#";
            default: throw new IllegalArgumentException("Unknown note: " + toAbbreviate);
        };
        return myString;
    }
}
