/*
 * 	Notes:
 * 	- Approach from top-down
 * 		- fretDotLabel extends JLabel
 * 		- fretboardLabel extends JLabel
 * 		- fretboardPanel extends JPanel
 * 		- toolPanel extends JPanel
 * 			- stringTuningBox extends JComboBox
 * 			- scaleModeBox extends JComboBox
 */

package ui;

import javax.swing.*;
import javax.swing.border.Border;

import test.VisualTesting;

import java.awt.*;

public class MainFrame extends JFrame {
	
	HeaderPanel header;
	FretboardPanel fretboard;
	ToolPanel tool;
	TuningPanel tuning;
	ScalePanel scale;
	ScaleFormPanel scaleform;
	KeyPanel key;
	
	String APP_NAME = "Scale Generator";
	
	public MainFrame() {;
		
		// Initialize frame
		this.setTitle(APP_NAME);
		this.setSize(1440, 720);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		header = new HeaderPanel();
		fretboard = new FretboardPanel();
		tool = new ToolPanel();
		tuning = new TuningPanel();
		scale = new ScalePanel();
		scaleform = new ScaleFormPanel();
		key = new KeyPanel();

		scale.add(key);
		scale.add(scaleform);
		
		tool.add(tuning, BorderLayout.WEST);
		tool.add(scale, BorderLayout.EAST);

		scaleform.setScaleFormChangeListener(fretboard);
		key.setKeyChangeListener(fretboard);
		tuning.setTuningChangeListener(fretboard);
		
		// Set frame visible
		this.add(header, BorderLayout.NORTH);
		this.add(fretboard, BorderLayout.CENTER);
		this.add(tool, BorderLayout.SOUTH);
	}
	
}
