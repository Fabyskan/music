public class Note {
    private NoteValue value;
    private NoteName name;
    private Note nextNote;

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

    public Note(final String name, final String value) {
        this(
            NoteName.fromAbbreviation(name),
            NoteValue.fromAbbreviation(value)
        );
    }
    /*
    Konstruktor, der Strings annimmt und mit den parse Methoden dann den oberen Konstruktor aufruft
     */

    public void getNoteValue(Note note) {
        System.out.println("Die Note hat den Wert: "+note.value);
    }

    public void getNoteName() {
        System.out.println("Die Note hat dne Namen: "+this.name);
    }

    public Note getNextNote() {
        System.out.println("Die nächste Note ist: "+this.nextNote);
        return this.nextNote;
    }

    public void setNextNote(Note note) {
        nextNote = note;
    }

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

    public static String toString(Note note) {
        String value = NoteValue.getAbbreviation(note.value);
        String name = NoteName.getAbbreviation(note.name);
        return name + ":" + value;
    }
    /*
    * Nutzt die getAbbreviation Methoden, um die Notenbestandteile in Strings umzuwandeln und konkateniert sie
    * */

    public double getPitch() {
        double x = this.name.ordinal();
        double pitch = 440 * Math.pow(2,x/12);
        return pitch;
    }
    /*
    * nimmt sich über die ordinal Methode die Zahl, die hinter der enum steckt und
    * */
}

