public class Melody {
    private Note firstNote;

    /**
     * Konstruktor für die Erste Note
     * @param firstNote
     */
    public Melody(Note firstNote) {
       /* if (firstNote == null) {
            throw new IllegalArgumentException("firstNote shall not be null!");
        } */ // verursacht einen diabolischen Fehler
        this.firstNote = firstNote;
    }

    /**
     * Getter für FirstNote
     * @return Erste Note
     */

    public Note getFirstNote() {
        return firstNote;
    }
    // Getter für FirstNote

    /**
     * Getter für die letzte Note der Melodie
     * @return Letzte Note
     */
    public Note getLastNote() {
        if (firstNote == null) {
            return null;
        }
        Note current = firstNote;
        while (current.getNextNote() != null) {
            current = current.getNextNote();
        }
        return current;
    }
    // Getter für die letzte Note am Ende der Liste

    /**
     * Prüft ob Note schon enthalten ist
     * @param nextNote Zu prüfende Note
     * @return Wahr oder Falsch
     */
    public boolean contains(Note nextNote) {
        Note current = firstNote;
        while (current != null) {
            if (current == nextNote) {
                return true;
            }
            current = current.getNextNote();
        }
        return false;
    }
    // Geht die Liste durch und prüft ob die Objektreferenz gleich ist, falls nicht geht er bis ans Ende und gibt dann false zurück

    /**
     * Fügt eine Note zur Melodie hinzu
     * @param note Die zu hinzufügende Note
     */
    public void addNote(Note note) {
        Note current = this.firstNote;
        if (current == null) {
            this.firstNote = note;
            return;
        }
        while (current.getNextNote() != null) {
            if (contains(note)) {
                throw new IllegalArgumentException("Note already exists!");
            }
            current = current.getNextNote();
        }
        current.setNextNote(note);
    }

    /**
     * Ersetzt eine Note
     * @param newNote Neue einzusetzende Note
     * @param index Stelle an der die Note eingesetzt werden soll
     */
    public void replaceNote(Note newNote, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (this.contains(newNote)) {
            throw new IllegalArgumentException("Note already exists!");
        }
        if (index == 0) {
            newNote.setNextNote(firstNote.getNextNote());
            firstNote = newNote;
            return;
        }

        Note current = this.firstNote;
        int i = 0;
        while (current != null && i < index -1) {
            current = current.getNextNote();
            i++;
        }
        if (current == null || current.getNextNote() == null) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        newNote.setNextNote(current.getNextNote().getNextNote());
        current.setNextNote(newNote);

        /*for (int i = 0; i < index; i++) {
            current = current.getNextNote();
        }
        current.setNextNote(newNote);*/
    }

    /**
     * Baut die Ausgabe zusammen
     * @return Gibt die Melodie als String aus
     */
    @Override
    public String toString() {
        if (firstNote == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Note current = this.firstNote;

        while (current != null) {
            sb.append(current.toString());
            if (current.getNextNote() != null) {
                sb.append(",");
            }
            current = current.getNextNote();
        }
        return sb.toString();


        /*Note current = this.firstNote;
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
        return noteString;*/
    }

    /**
     * Prüft ob zwei Noten gleich sind
     * @param obj Zu prüfende Note
     * @return Wahr oder Falsch
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Wenn beide Objekte gleich sind
        if (!(obj instanceof Melody other)) return false;

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