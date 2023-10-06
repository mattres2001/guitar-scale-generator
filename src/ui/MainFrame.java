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
	
	String APP_NAME = "Scale Generator";
	
	public MainFrame() {;
		
		// Initialize frame
		this.setTitle(APP_NAME);
		this.setSize(1440, 720);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		// Set frame visible
		this.add(new HeaderPanel(), BorderLayout.NORTH);
		this.add(new FretboardPanel(), BorderLayout.CENTER);
		this.add(new ToolPanel(), BorderLayout.SOUTH);
	}
	
}
