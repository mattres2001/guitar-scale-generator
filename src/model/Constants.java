package model;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	/*
	 *  If changing value of frets, update X_POSITIONS of in Frets.java
	 * 
	 */
	public static int STRINGS = 6;
	public static int FRETS = 24;
	
	public static final char[] NotePitch = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G'
	};
	
	public static final String[] Note = {
			 "Ab", "A", "A#", 
			 "Bb", "B", 
			 "Cb", "C", "C#", 
			 "Db", "D", "D#", 
			 "Eb", "E",
			 "Fb", "F", "F#",
			 "Gb", "G", "G#"
	};
	
	public enum NoteQuality {
		NATURAL, FLAT, SHARP
	}
	
	public enum IntervalForm {
		ROOT,
		MINOR_SECOND, MAJOR_SECOND, MINOR_THIRD,
		MAJOR_THIRD, PERFECT_FOURTH, AUGMENTED_FOURTH,
		TRI_TONE, //use this for now instead of aug4 or dim5
		DIMINISHED_FIFTH, PERFECT_FIFTH, 
		AUGMENTED_FIFTH, MINOR_SIXTH, 
		MAJOR_SIXTH, MINOR_SEVENTH, MAJOR_SEVENTH, 
		OCTAVE
	}
	
	// to add new scale form, register in Scale.toString()
	public enum ScaleForm {
		MAJOR, MAJOR_PENTATONIC, MAJOR_BLUES,
		IONIAN, DORIAN, PHYRGIAN, 
		LYDIAN, MIXOLYDIAN, AEOLIAN, 
		LOCRIAN, MINOR, MINOR_PENTATONIC, 
		MINOR_BLUES, HARMONIC_MINOR, CHROMATIC
	}
	
	public enum ChordForm {
		MAJOR, AUGMENTED, MINOR, 
		DIMINISHED, SUSPENDED4, SUSPENDED2,
		MAJOR7, DOMINANT7, MINOR7,
		MINOR7FLAT5, DIMINISHED7, MAJOR9,
		DOMINANT9, DOMINANT11, DOMINANT13
	}
	
	public enum ChordCategory {
		TRIAD, SEVENTH, EXTENDED 
	}
	
	// register scales here
	public static String scaleFormToString(ScaleForm scale) {
		String str = "";
		
		switch (scale) {
		case MAJOR: str += "major"; break;
		case MAJOR_PENTATONIC: str += "major pentatonic"; break;
		case MAJOR_BLUES: str += "major blues"; break;
		case IONIAN: str += "ionian"; break;
		case DORIAN: str += "dorian"; break;
		case PHYRGIAN: str += "phrygian"; break;
		case LYDIAN: str += "lydian"; break;
		case MIXOLYDIAN: str += "mixolydian"; break;
		case AEOLIAN: str += "aeolian"; break;
		case LOCRIAN: str += "locrian"; break;
		case MINOR: str += "minor"; break;
		case MINOR_PENTATONIC: str += "minor pentatonic"; break; 
		case MINOR_BLUES: str += "minor blues"; break;
		case HARMONIC_MINOR: str += "harmonic minor"; break;
		case CHROMATIC: str += "chromatic";
		}
		
		return str;
	}

	public static String intervalFormToStrNotation(IntervalForm interval) {
		String str = "";
		
		return str;
	}
	
	public static String intervalFormToString(IntervalForm interval) {
		String str = "";
		
		switch (interval) {
		case ROOT: str += "root"; break;
		case MINOR_SECOND: str += "minor second"; break; 
		case MAJOR_SECOND: str += "major second"; break;
		case MINOR_THIRD: str += "minor third"; break;
		case MAJOR_THIRD: str += "major third"; break;
		case PERFECT_FOURTH: str += "perfect fourth"; break;
		case AUGMENTED_FOURTH: str += "augmented fourth"; break;
		case TRI_TONE: str += "tri-tone"; break;
		case DIMINISHED_FIFTH: str += "diminished fifth"; break;
		case PERFECT_FIFTH: str += "perfect fifth"; break;
		case AUGMENTED_FIFTH: str += "augmented fifth"; break;
		case MINOR_SIXTH: str += "minor sixth"; break;
		case MAJOR_SIXTH: str += "major sixth"; break;
		case MINOR_SEVENTH: str += "minor seventh"; break;
		case MAJOR_SEVENTH: str += "major seventh"; break;
		case OCTAVE: str += "octave"; break;
		}
		
		return str;
	}
			
	public static int intervalFormToInt(IntervalForm interval) {
		int num = 1;
		
		switch (interval) {
		case ROOT:
		case OCTAVE:
			break;
		case MINOR_SECOND: 
		case MAJOR_SECOND:
			num = 2;
			break;
		case MINOR_THIRD:
		case MAJOR_THIRD:
			num = 3;
			break;
		case PERFECT_FOURTH: 
		case AUGMENTED_FOURTH: 
			num = 4;
			break;
		case TRI_TONE:
		case DIMINISHED_FIFTH:
		case PERFECT_FIFTH:
		case AUGMENTED_FIFTH:
			num = 5;
			break;
		case MINOR_SIXTH:
		case MAJOR_SIXTH: 
			num = 6;
			break; 
		case MINOR_SEVENTH:
		case MAJOR_SEVENTH:
			num = 7;
			break;
		}
		
		return num;
	}
	
	public static int intervalFormToSemitones(IntervalForm interval) {
		int num = 0;
		
		switch (interval) {
		case ROOT: break;
		case MINOR_SECOND: num = 1; break; 
		case MAJOR_SECOND: num = 2; break;
		case MINOR_THIRD: num = 3; break;
		case MAJOR_THIRD: num = 4; break;
		case PERFECT_FOURTH: num = 5; break;
		case AUGMENTED_FOURTH:
		case TRI_TONE:
		case DIMINISHED_FIFTH: num = 6; break;
		case PERFECT_FIFTH: num = 7; break;
		case AUGMENTED_FIFTH:
		case MINOR_SIXTH: num = 8; break;
		case MAJOR_SIXTH: num = 9; break; 
		case MINOR_SEVENTH: num = 10; break;
		case MAJOR_SEVENTH: num = 11; break;
		case OCTAVE: num = 12;
		}
		
		return num;
	}
	
	/* doesn't incorporate AUGMENTED_FOURTH, DIMINISHED_FIFTH, 
	 * and AUGMENTED_FIFTH
	 * 	- add these when move to NewScaleFormulas.txt
	 */
	public static IntervalForm semitonesToIntervalForm(int semitones) {
		IntervalForm interval = IntervalForm.ROOT;
		switch (semitones) {
		case 0: break;
		case 1: interval = IntervalForm.MINOR_SECOND; break;
		case 2: interval = IntervalForm.MAJOR_SECOND; break;
		case 3: interval = IntervalForm.MINOR_THIRD; break;
		case 4: interval = IntervalForm.MAJOR_THIRD; break;
		case 5: interval = IntervalForm.PERFECT_FOURTH; break;
		case 6: interval = IntervalForm.TRI_TONE; break;
		case 7: interval = IntervalForm.PERFECT_FIFTH; break;
		case 8: interval = IntervalForm.MINOR_SIXTH; break;
		case 9: interval = IntervalForm.MAJOR_SIXTH; break;
		case 10: interval = IntervalForm.MINOR_SEVENTH; break;
		case 11: interval = IntervalForm.MAJOR_SEVENTH; break;
		case 12: interval = IntervalForm.OCTAVE; break;
		
		}
			
		return interval;
	}

	public static IntervalForm nextInterval(IntervalForm interval) {
		if (interval == IntervalForm.OCTAVE)
			return IntervalForm.MINOR_SECOND;
		
		int currentSemitone = intervalFormToSemitones(interval);
		
		return semitonesToIntervalForm(++currentSemitone);
	}
}

