/* 
 * To-Do List:
 * - KeyPanel
 * - Rename ScalePanel to ScaleFormPanel
 * - ScalePanel.add(KeyPanel)
 * - ScalePanel.add(ScaleFormPanel) 
 * - Rename ToolPanel to FooterPanel
 */

package model;

import static model.Constants.*;

import javax.swing.*;

import test.VisualTesting;
import ui.MainFrame;

public class ScaleGeneratorApp {

	public static void main(String[] args) {
		// Enable bounds testing mode
		VisualTesting.panelBoundsEnabled = false;

		/*
		Note note = new Note('C', NoteQuality.NATURAL);
		Scale cPent = new Scale(note, ScaleForm.MAJOR_PENTATONIC);
		Note bNote = new Note('B', NoteQuality.NATURAL);
		Note gNote = new Note('G', NoteQuality.NATURAL);
		Note dNote = new Note('D', NoteQuality.NATURAL);
		Note aNote = new Note('A', NoteQuality.NATURAL);
		Note eNote = new Note('E', NoteQuality.NATURAL);
		Note[] eadgbe = {eNote, bNote, gNote, dNote, aNote, eNote};
		Fretboard fretboard = new Fretboard(cPent, eadgbe);
		System.out.println(fretboard);
		*/
		
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new MainFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
	}

}



