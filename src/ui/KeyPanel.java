package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Constants;
import model.KeyChangeListener;
import test.VisualTesting;

public class KeyPanel extends JPanel implements ActionListener {
	
	JComboBox<String> keyBox;
	Border border;
	private KeyChangeListener listener;
	
	public KeyPanel() {
		initializeBorder(VisualTesting.panelBoundsEnabled);
		
		keyBox = new JComboBox<String>(Constants.Note);
		keyBox.setSelectedItem("C");
		keyBox.addActionListener(this);
		
		this.setBackground(Color.white);
		this.add(keyBox);
		
	}
	
	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createDashedBorder(Color.green, (float)2.0, (float)3.0);
			this.setBorder(border);
		}
	}

	public void setKeyChangeListener(KeyChangeListener listener) {
		this.listener = listener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == keyBox) {
			if (listener != null) {
				listener.onKeyChange(keyBox.getSelectedItem());
			}
		}
	}
	
}
