package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Constants;
import test.VisualTesting;

public class StringPanel extends JPanel{

	Border border;
	JLabel stringLabel;
	JComboBox<String> stringBox;

	public StringPanel(String labelString) {
		initializeBorder(VisualTesting.panelBoundsEnabled);
		
		stringLabel = new JLabel(labelString);
		stringBox = new JComboBox<String>(Constants.Note);
		
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout(5, 5));
		this.add(stringLabel, BorderLayout.WEST);
		this.add(stringBox, BorderLayout.EAST);
	}	
	
	
	public JLabel getJLabel() {
		return stringLabel;
	}
	
	public JComboBox<String> getJComboBox() {
		return stringBox;
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createDashedBorder(Color.pink, (float)2.0, (float)3.0);
			this.setBorder(border);
		}
	}
	
}
