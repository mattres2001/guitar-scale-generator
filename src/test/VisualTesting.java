package test;

import java.util.Map;

import model.Constants.NoteQuality;
import model.Constants.ScaleForm;
import model.Fretboard;
import model.Note;
import model.Scale;

import java.util.HashMap;

public class VisualTesting {
	
	public static boolean panelBoundsEnabled = false;
	
	public static Map<Integer, boolean[]> chromaticScale() {
		Map<Integer, boolean[]> map = new HashMap<>();
		boolean[] allTrue = new boolean[24]; 
		for (int i = 0; i < 24; i++)
			allTrue[i] = true;
		for (int i = 0; i < 6; i++)
			map.put(i, allTrue);
		return map;
	}
	
	public static Map<Integer, boolean[]> cMajorScaleInEADGBE() {
		Note note = new Note('C', NoteQuality.NATURAL);
		Scale cPent = new Scale(note, ScaleForm.MAJOR_PENTATONIC);
		Note bNote = new Note('B', NoteQuality.NATURAL);
		Note gNote = new Note('G', NoteQuality.NATURAL);
		Note dNote = new Note('D', NoteQuality.NATURAL);
		Note aNote = new Note('A', NoteQuality.NATURAL);
		Note eNote = new Note('E', NoteQuality.NATURAL);
		Note[] eadgbe = {eNote, bNote, gNote, dNote, aNote, eNote};
		Fretboard fretboard = new Fretboard(cPent, eadgbe);
		return fretboard.getFretboard();
	}
}
