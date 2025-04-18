public enum NoteName {
    A("A"),
    A_SHARP("A#"),
    B("B"),
    B_SHARP("B#"),
    C("C"),
    C_SHARP("C#"),
    D("D"),
    D_SHARP("D#"),
    E("E"),
    E_SHARP("E#"),
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
            case "B#": yield B_SHARP;
            case "C": yield C;
            case "C#": yield C_SHARP;
            case "D": yield D;
            case "D#": yield D_SHARP;
            case "E": yield E;
            case "E#": yield E_SHARP;
            case "F": yield F;
            case "F#": yield F_SHARP;
            case "G": yield G;
            case "G#": yield G_SHARP;
            default: throw new IllegalArgumentException("Unknown abbreviation: " + abbreviation);
        };
        return name;
    }
}
