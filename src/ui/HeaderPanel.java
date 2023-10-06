package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import test.VisualTesting;

public class HeaderPanel extends JPanel {

	Border border;
	
	public HeaderPanel() {
		initializeBorder(VisualTesting.panelBoundsEnabled);
		this.setPreferredSize(new Dimension(1440, 90));
		this.setBackground(Color.white);
	}

	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createLineBorder(Color.red, 5);
			this.setBorder(border);	
		}
	}
	
}
