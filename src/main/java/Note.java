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

    public Note(final String name, final String value) {
        this(
            NoteName.fromAbbreviation(name),
            NoteValue.fromAbbreviation(value)
        );
    }

    public void getNoteValue(Note note) {
        System.out.println("Die Note hat den Wert: "+note.value);
    }

    public void getNoteName(Note note) {
        System.out.println("Die Note hat dne Namen: "+note.name);
    }

    public void getNextNote(Note note) {
        System.out.println("Die nächste Note ist: "+note.nextNote);
    }
}

/*
                * if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Note name shall not be null or empty!");
        }
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Note value shall not be null or empty!");
        }
        NoteName parsedName = NoteName.fromAbbreviation(name);
        NoteValue parsedValue = NoteValue.fromAbbreviation(value);
*/