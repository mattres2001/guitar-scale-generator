package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Constants;
import test.VisualTesting;

public class ScaleFormPanel extends JPanel {

	JComboBox<Object> scalesBox;
	Object[] scales;
	Border border;
	
	public ScaleFormPanel() {
		
		this.setBackground(Color.white);
		initializeBorder(VisualTesting.panelBoundsEnabled);
		initializeScaleBox();
	}
	
	public void initializeScaleBox() {
		ArrayList<String> scalesList = new ArrayList<String>();
		for (Constants.ScaleForm s : Constants.ScaleForm.values()) {
			scalesList.add(Constants.scaleFormToString(s));
		}
		scales = scalesList.toArray();
		scalesBox = new JComboBox<Object>(scales);
		scalesBox.setMaximumSize(new Dimension(100, 20));
		this.add(scalesBox);
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createDashedBorder(Color.cyan, (float)2.0, (float)3.0);
			this.setBorder(border);
		}
	}
}
