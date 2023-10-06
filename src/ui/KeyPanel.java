package ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Constants;

import test.VisualTesting;

public class KeyPanel extends JPanel {
	
	JComboBox<String> keyBox;
	Border border;
	
	public KeyPanel() {
		initializeBorder(VisualTesting.panelBoundsEnabled);
		
		keyBox = new JComboBox<String>(Constants.Note);
		
		this.setBackground(Color.white);
		this.add(keyBox);
		
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createDashedBorder(Color.green, (float)2.0, (float)3.0);
			this.setBorder(border);
		}
	}
	
}
