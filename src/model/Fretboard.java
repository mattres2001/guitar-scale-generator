package model;

import java.util.HashMap;
import java.util.Map;

import static model.Constants.*;

import java.util.ArrayList;

public class Fretboard {

	private Scale scale;
	private Note[] tuning; // [0-5]=[EADGBE]
	private Map<Integer, boolean[]> fretboard = new HashMap<>();
	/* C major-pentatonic
	 * i=pitch -> [0,1,2,3,...,23]
	 * 0=E -> 
	 * 1=B -> 
	 * 2=G -> 
	 * 3=D ->
	 * 4=A ->
	 * 5=E -> [t,f,f,t,..]
	 */
	
	public Fretboard(Scale scale, Note[] tuning) {
		this.tuning = tuning;
		this.scale = scale;
		this.initFretboard();
	}
	
	public Fretboard(Scale scale) {
		Note e = new Note('E', NoteQuality.NATURAL);
		Note a = new Note('A', NoteQuality.NATURAL);
		Note d = new Note('D', NoteQuality.NATURAL);
		Note b = new Note('B', NoteQuality.NATURAL);
		Note g = new Note('G', NoteQuality.NATURAL);
		Note[] eadgbe = {e, b, g, d, a, e};
		this.tuning = eadgbe;
		this.scale = scale;
		this.initFretboard();
		
	}
	
	private void initFretboard() {
		// assign fret positions for each string
		Note key = scale.getKey();
		boolean[] fretPositions;
		for (int i = 0; i < Constants.STRINGS; i++) {
			fretPositions = new boolean[Constants.FRETS];
			
			Note openNote = tuning[i];
			IntervalForm currentInterval = openNote.intervalFromNote(key);
			
			// find fret positions
			for (int fret = 0; fret < Constants.FRETS; fret++) {
				
				// check if interval is in scale with intervalExists()
				fretPositions[fret] = (scale.intervalExists(currentInterval));
				currentInterval = nextInterval(currentInterval);
				
			}
			
			// map fret positions to string
			fretboard.put(i, fretPositions);
		
		}
	}

	public Map<Integer, boolean[]> getFretboard() {
		return fretboard;
	}
	
	public String toString() {
		String str = "";
		
		for (int i = 0; i < Constants.STRINGS; i++) {
			str += "[string " + (i + 1) + ": " + tuning[i] + " = ";
			
			for (int fret = 0; fret < Constants.FRETS; fret++) {
				if ((fretboard.get(i))[fret]) {
					str += fret + " ";
				}
				
			}
			
			
			str += "]\n";
		}
		
		return str;
	}

}
