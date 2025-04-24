public class Melody {
    private Note firstNote;

    public Melody(Note firstNote) {
        if (firstNote == null) {
            throw new IllegalArgumentException("firstNote shall not be null!");
        }
        this.firstNote = firstNote;
    }

    public void getFirstNote(Note firstNote) {
        System.out.println("First Note: " + firstNote);
    }

    public boolean contains(Note firstNote, Note nextNote) {
        Note current = firstNote;
        while (current != null) {
            if (current.equals(nextNote)) {
                return true; // Referenz gefunden
            }
            current = current.getNextNote();
        }
        return false;
    }

    public void addNote(Note note) {
        Note current = this.firstNote;
        if (current == null) {
            this.firstNote = note;
            return;
        }
        while (current.getNextNote() != null) {
            if (current == current.getNextNote()) {
                throw new IllegalArgumentException("Note already exists!");
            }
            current.setNextNote(note);
        }
        note.setNextNote(current);
    }

    public void replaceNote(Note newNote, int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index shall not be 0!");
        }
        Note current = this.firstNote;
        if (contains(current, newNote)) {
            throw new IllegalArgumentException("Note already exists!");
        }
        for (int i = 0; i < index; i++) {
            current = current.getNextNote();
        }
        current.setNextNote(newNote);
    }


    public String toString() {
        Note current = this.firstNote;
        String noteString = "";
        if (firstNote == null) {
            return "";
        }
        while (current.getNextNote() != null) {
            if (current == current.getNextNote()) {
                throw new IllegalArgumentException("Note already exists!");
            }
            noteString = noteString + "," + Note.toString(current);
            current = current.getNextNote();
        }
        return noteString;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true; // Wenn beide Objekte gleich sind
        if (obj == null || getClass() != obj.getClass()) return false; // Null oder falscher Typ

        Melody other = (Melody) obj; // Casten des Objekts auf die passende Klasse

        Note currentThis = this.firstNote;
        Note currentOther = other.firstNote;

        // Beide Listen müssen die gleiche Länge haben und jede Note muss übereinstimmen
        while (currentThis != null && currentOther != null) {
            if (!currentThis.equals(currentOther)) {
                return false; // Eine der Noten ist nicht gleich, also false
            }
            currentThis = currentThis.getNextNote(); // Weiter zur nächsten Note
            currentOther = currentOther.getNextNote(); // Weiter zur nächsten Note
        }

        // Falls beide Listen zu Ende sind, sind sie gleich, wenn nicht, sind sie unterschiedlich
        return currentThis == null && currentOther == null;
    }

}

/*
Bro equals ist kacke das soll eher so note.equals(note2) werden dageht grad noch goar nix außerdem soll das nicht
mit equals prüfen. Sondern die ObjektID
 */