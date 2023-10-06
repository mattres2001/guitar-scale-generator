package ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import test.VisualTesting;

public class ScalePanel extends JPanel {

	ScaleFormPanel scaleFormPanel;
	KeyPanel keyPanel;
	Border border;
	
	public ScalePanel() {
		
		this.setBackground(Color.white);
		initializeBorder(VisualTesting.panelBoundsEnabled);

		//this.add(new KeyPanel());
		//this.add(new ScaleFormPanel());
		
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createLineBorder(Color.pink, 3);
			this.setBorder(border);
		}
	}
	
}
