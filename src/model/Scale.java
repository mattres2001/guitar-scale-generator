package model;

import static model.Constants.*;
import static model.Helper.*;

import model.Constants.ScaleForm;

public class Scale {
	
	private Note key;
	private Note[] notes;
	private IntervalForm[] intervals;
	private ScaleForm scale;
	private IntervalForm characteristic;
	
	public Scale(Note key, ScaleForm scale) {
		this.key = key;
		this.scale = scale;
		this.notes = notesInScale();
	}
	
	public Note[] notesInScale() {
		// get scale formula
		String formula = findFormula(scaleFormToString(this.scale));
		
		// initialize scale and key
		Note[] notes = new Note[formula.length() + 1];
		notes[0] = this.key;
		
		// initialize intervals array
		IntervalForm[] intervals = new IntervalForm[formula.length() + 1];
		intervals[0] = IntervalForm.ROOT;
		
		// track existing pitches
		char[] pitches = new char[formula.length()];
		pitches[0] = this.key.getNotePitch();
		
		// track number of semitones
		int semitones = 0;
		
		// process each char of formula
		char current;
		for (int i = 0; i < formula.length(); i++) {	
			current = formula.charAt(i);
			
			// add note and count semitones
			if (current == 'H') {
				semitones++;
				notes[i + 1] = notes[i].countHalfStepsUp(1);
			}
			else if (current == 'W') {
				semitones += 2;
				notes[i + 1] = notes[i].countHalfStepsUp(2);
			}
			else if (current == 'T') {
				semitones += 3;
				notes[i + 1] = notes[i].countHalfStepsUp(3);
			}
			
			// check if pitch already in scale (not accurate)
			if (notes.length != 0 && indexOf(pitches, notes[i + 1].getNotePitch()) != -1)
				notes[i + 1] = notes[i + 1].equivalentNote();
			
			// if pitch not in scale, add to existing pitches
			if (i != formula.length() - 1)
				pitches[i + 1] = notes[i + 1].getNotePitch();
			
			// set note interval
			IntervalForm interval = semitonesToIntervalForm(semitones);
			notes[i + 1].setNoteInterval(interval);
			intervals[i + 1] = interval;
		}
		
		this.intervals = intervals;
		return notes;
	}
	
	public boolean intervalExists(IntervalForm interval) {
		return (indexOf(intervals, interval) != -1); 
	}
	
	public Note get(IntervalForm interval) {
		assert (intervalExists(interval)) : "interval not in scale"; 
		return notes[indexOf(intervals, interval)];
	}
	
	public Note getKey() { return this.key; }
	
	public Note[] getNotes() { return this.notes; }
	
	public ScaleForm getScaleForm() { return this.scale; }
	
	public void setKey(Note key) { 
		this.key = key; 
		this.notes = notesInScale();
	}
	
	public void setScaleForm(ScaleForm scale) { 
		this.scale = scale; 
		this.notes = notesInScale();
	}
	
	public String toString() {
		String str = "[";
		for (int i = 0; i < notes.length; i++) {
			str += this.notes[i];
			if (i != notes.length - 1)
				str += ", ";
		}
		str += ']';
		return str;
	}
	
}
