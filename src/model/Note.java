package model;

import static model.Constants.*;
import static model.Helper.*;

public class Note {
	
	private char pitch;
	private NoteQuality quality;
	private IntervalForm interval;
	
	public Note(char letter, NoteQuality quality) {
		this.pitch = letter;
		this.quality = quality;
		this.interval = IntervalForm.ROOT;
	}
	
	// used when related to another note
	public Note(char letter, NoteQuality quality, IntervalForm interval) {
		this.pitch = letter;
		this.quality = quality;
		this.interval = interval;
	}
	
	public Note(Object str) {
		String noteStr = str.toString();
		this.pitch = noteStr.charAt(0);
		this.quality = (noteStr.length() < 2) ? NoteQuality.NATURAL :
				((noteStr.charAt(1) == 'b') ? NoteQuality.FLAT : NoteQuality.SHARP);
		this.interval = IntervalForm.ROOT;
	}
	
	protected Note noteAtInterval(IntervalForm interval) {
		Note intervalNote = this;
		if (interval == IntervalForm.OCTAVE || interval == IntervalForm.ROOT)
			return intervalNote;
		
		for (int i = 0; i < intervalFormToSemitones(interval); i++)
			intervalNote = intervalNote.halfStepUp();
		
		return intervalNote;
	}
	
	// assuming note is before this
	protected IntervalForm intervalFromNote(Note note) {
		if (this.equals(note))
			return IntervalForm.ROOT;
		
		// count semitones until note is equal
		Note noteIterator = new Note(note.pitch, note.quality);
		int semitones = 0;
		while (!noteIterator.equals(this, true)) {
			semitones++;
			noteIterator = noteIterator.halfStepUp();
		}
		
		return semitonesToIntervalForm(semitones);
	}
	
	protected IntervalForm intervalToNote(Note note) {
		if (this.equals(note))
			return IntervalForm.OCTAVE;
		
		// count semitones until note is equal
		Note noteIterator = this;
		int semitones = 0;
		while (!noteIterator.equals(note)) {
			semitones++;
			noteIterator = noteIterator.halfStepUp();
		}
		
		// return interval
		return semitonesToIntervalForm(semitones);
	}
	
	// will default to return sharp
	protected Note halfStepUp() {
		
		char pitch = this.pitch;
		NoteQuality quality = this.quality;
		
		switch (quality) {
		case NATURAL:
			if (pitch == 'B' || pitch == 'E')
				pitch = NotePitch[indexOf(NotePitch, pitch) + 1];
			else
				quality = NoteQuality.SHARP;
			break;
		case SHARP:
			quality = NoteQuality.NATURAL;
			pitch = (pitch == 'G') ? pitch = 'A' : NotePitch[indexOf(NotePitch, pitch) + 1];
			break;
		case FLAT: 
			quality = NoteQuality.NATURAL;
			break;
		}
		
		return new Note(pitch, quality);
	}
	
	// will default to return flat
	protected Note halfStepDown() {}
	
	protected Note countHalfStepsUp(int halfSteps) {
		assert(halfSteps > 0);
		Note current = this;
		for (int i = 0; i < halfSteps; i++)
			current = current.halfStepUp();
		return current;
	}
	
	protected Note countHalfStepsDown(int halfSteps) {
		assert(halfSteps > 0);
	}
	
	protected Note equivalentNote() {
		Note alternateNote = new Note(this.pitch, this.quality);;
		switch (quality) {
		case NATURAL:
			break;
		case SHARP:
			if (this.pitch == 'G')
				alternateNote = new Note('A', NoteQuality.FLAT);
			else
				alternateNote = new Note(NotePitch[indexOf(NotePitch, this.pitch) + 1], NoteQuality.FLAT);
			break;
		case FLAT:
			if (this.pitch == 'C')
				alternateNote = new Note('B', NoteQuality.NATURAL);
			else if (this.pitch == 'F')
				alternateNote = new Note('E', NoteQuality.NATURAL);
			else if (this.pitch == 'A')
				alternateNote = new Note('G', NoteQuality.SHARP);
			else
				alternateNote = new Note(NotePitch[indexOf(NotePitch, this.pitch) - 1], NoteQuality.SHARP);
			break;
		}
		return alternateNote;
	}
	
	public String toString() {
		String str = "";
		str += pitch;
		
		switch (quality) {
		case NATURAL: break;
		case SHARP: str += '#'; break;
		case FLAT: str += 'b'; break;
		}
		
		return str;
	}
	
	protected void setNotePitch(char pitch) { this.pitch = pitch; }
	
	protected void setNoteInterval(IntervalForm interval) { this.interval = interval; }
	
	protected void setNoteQuality(NoteQuality quality) { this.quality = quality; }
	
	protected char getNotePitch() { return this.pitch; }
	
	protected IntervalForm getNoteInterval() { return this.interval; }
	
	protected NoteQuality getNoteQuality() { return this.quality; }
	
	public boolean equals(Note note) {
		return this.equals(note, false);
	}
	
	public boolean equals(Note note, boolean equivalent) {
		if (equivalent) {
			Note equivalentNote = note.equivalentNote();
			if (this.pitch == note.pitch && this.quality == note.quality) 
				return true;
			else if (this.pitch == equivalentNote.pitch && this.quality == equivalentNote.quality)
				return true;
		}
		else {
			if (this.pitch == note.pitch && this.quality == note.quality)
				return true;
		}
			
			
		return false;
	}
	
}