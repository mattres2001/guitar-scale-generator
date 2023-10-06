package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Fretboard;
import model.KeyChangeListener;
import model.Note;
import model.Scale;
import model.Constants;
import model.Constants.NoteQuality;
import model.Constants.ScaleForm;
import test.VisualTesting;

@SuppressWarnings("serial")
public class FretboardPanel extends JPanel implements TuningChangeListener, KeyChangeListener, ScaleFormChangeListener {

	// JComponents
	Border labelBorder;
	Border panelBorder;
	JLabel fretboardLabel;
	ImageIcon fretboardImage;
	
	// Coordinates
	private final int FRETBOARD_WIDTH = 1260;
	private final int FRETBOARD_HEIGHT = 180;
	private final int PANEL_WIDTH = 1440;
	private final int PANEL_HEIGHT = 360;
	private final int PANEL_X_POS = (PANEL_WIDTH - FRETBOARD_WIDTH) / 2 - 10;
	private final int PANEL_Y_POS = 75;
	
	// Default State
	private Note fretboardKey = new Note('C', NoteQuality.NATURAL);
	private Note[] fretboardTuning = {
				new Note('E', NoteQuality.NATURAL),
				new Note('B', NoteQuality.NATURAL),
				new Note('G', NoteQuality.NATURAL),
				new Note('D', NoteQuality.NATURAL),
				new Note('A', NoteQuality.NATURAL),
				new Note('E', NoteQuality.NATURAL),
			};
	private Scale fretboardScale = new Scale(fretboardKey, ScaleForm.MAJOR_PENTATONIC);
	private Fretboard fretboard = new Fretboard(fretboardScale, fretboardTuning);
	
	public FretboardPanel() {
		// Set panel layout
		this.setLayout(null);
		
		// Set ImageIcon
		fretboardImage = Iconify.iconify("fretboard-template.png", FRETBOARD_WIDTH, FRETBOARD_HEIGHT);
		
		// Set border
		initializeBorder(VisualTesting.panelBoundsEnabled);
		
		// Initialize panel
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			panelBorder = BorderFactory.createLineBorder(Color.blue, 5);
			this.setBorder(panelBorder);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		fretboardImage.paintIcon(this, g, PANEL_X_POS, PANEL_Y_POS);
		
		Frets.drawFrets(fretboard.getFretboard(), g);
		
	}
	
	@Override
	public void onTuningChange(int stringIndex, Object newTuning) {
		fretboardTuning[stringIndex] = new Note(newTuning.toString());
		fretboard = new Fretboard(fretboardScale, fretboardTuning);
		this.repaint();
	}

	@Override
	public void onKeyChange(Object newKey) {
		fretboardKey = new Note(newKey.toString());
		fretboardScale.setKey(fretboardKey);
		fretboard = new Fretboard(fretboardScale, fretboardTuning);
		this.repaint();
	}

	@Override
	public void onScaleFormChange(Object scaleForm) {
		fretboardScale.setScaleForm(Constants.stringToScaleForm(scaleForm.toString()));
		fretboard = new Fretboard(fretboardScale, fretboardTuning);
		this.repaint();
	}
}
