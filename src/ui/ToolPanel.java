package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Constants;
import test.VisualTesting;

public class ToolPanel extends JPanel {
	
	public ToolPanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1440, 270));
		this.setBackground(Color.white);
		
		initializeBorder(VisualTesting.panelBoundsEnabled);
		
		//this.add(new ScalePanel(), BorderLayout.EAST);
		//this.add(new TuningPanel(), BorderLayout.WEST);
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			this.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		}
	}
	

	
	
}
