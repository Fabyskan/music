public class Note {
    private NoteValue value;
    private NoteName name;
    private Note nextNote;

    /**
     * Konstruktor für die Noten mit dne Enum Typen
     * @param name Name der Note (C-F#)
     * @param value Tonhöhe der Note (Ganz bis Viertel)
     */
    public Note(final NoteName name, final NoteValue value) {
        if (name == null) {
            throw new IllegalArgumentException("Note name shall not be null!");
        }
        if (value == null) {
            throw new IllegalArgumentException("Note value shall not be null!");
        }
                this.name = name;
                this.value = value;
    }
    /*
    * Standardkonstruktor für Note der die Enumtypen annimmt
    *
    * */

    /**
     * Konstruktor der Strings nimmt, parsed und an den anderen Kosntruktor weitergibt
     * @param name Name der Note (C-F#)
     * @param value Tonhöhe der Note (Ganz bis Viertel)
     */
    public Note(final String name, final String value) {
        this(
            NoteName.parse(name),
            NoteValue.parse(value)
        );
    }
    /*
    Konstruktor, der Strings annimmt und mit den parse Methoden dann den oberen Konstruktor aufruft
     */

    /**
     * Getter für den Notenwert
     * @return Notenwert
     */
    public NoteValue getNoteValue() {
        return this.value;
    }

    /**
     * Getter für den Notennamen
     * @return Notenname
     */
    public NoteName getNoteName() {
        return this.name;
    }

    /**
     * Getter für die Nächste Note der Liste
     * @return Nächste Note
     */
    public Note getNextNote() {
        return this.nextNote;
    }

    /**
     * Setter für die nächste Note der Liste
     * @param note Die nächste Note
     */
    public void setNextNote(Note note) {
        nextNote = note;
    }

    /**
     * Prüft, ob zwei Noten gleich sind
     * @param obj Note
     * @return Wahr oder Falsch
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Note other = (Note) obj;

        return this.value == other.value &&
                this.name.equals(other.name);
    }
    /*
    * Vergleicht zwei Noten über ihre Werte und Namen. Zuerst die values, weil die schneller geprüft sind.
    * */

    /**
     * Baut aus Namen und Wert der Note einen String
     * @return Lesbarer String
     */
    @Override
    public String toString() {
        return name.getAbbreviation() + ":" + value.getAbbreviation();
    }
    /*
    * Nutzt die getAbbreviation Methoden, um die Notenbestandteile in Strings umzuwandeln und konkateniert sie
    * */

    /**
     * Errechnet sich den Ton der Note anhand der Formel
     * @return Notenton
     */
    public double getPitch() {
        double x = this.name.ordinal();
        double pitch = 440 * Math.pow(2,x/12);
        return pitch;
    }
    /*
    * nimmt sich über die ordinal Methode die Zahl, die hinter der enum steckt und
    * */
}

