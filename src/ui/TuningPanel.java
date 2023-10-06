package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import test.VisualTesting;

public class TuningPanel extends JPanel implements ActionListener{
	
	Border border;
	StringPanel string1Panel;
	StringPanel string2Panel;
	StringPanel string3Panel;
	StringPanel string4Panel;
	StringPanel string5Panel;
	StringPanel string6Panel;
	
	
	public TuningPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);
		initializeBorder(VisualTesting.panelBoundsEnabled);
		initializeStringBoxes();
	}
	
	public void initializeStringBoxes() {
		
		string1Panel = new StringPanel("String 1"); 
		string2Panel = new StringPanel("String 2");
		string3Panel = new StringPanel("String 3");
		string4Panel = new StringPanel("String 4");
		string5Panel = new StringPanel("String 5");
		string6Panel = new StringPanel("String 6");
		
		this.add(string1Panel);
		this.add(Box.createVerticalStrut(10));
		this.add(string2Panel);
		this.add(Box.createVerticalStrut(10));
		this.add(string3Panel);
		this.add(Box.createVerticalStrut(10));
		this.add(string4Panel);
		this.add(Box.createVerticalStrut(10));
		this.add(string5Panel);
		this.add(Box.createVerticalStrut(10));
		this.add(string6Panel);
	
		string1Panel.getJComboBox().setSelectedItem("E");
		string2Panel.getJComboBox().setSelectedItem("B");
		string3Panel.getJComboBox().setSelectedItem("G");
		string4Panel.getJComboBox().setSelectedItem("D");
		string5Panel.getJComboBox().setSelectedItem("A");
		string6Panel.getJComboBox().setSelectedItem("E");
		
		string1Panel.getJComboBox().addActionListener(this);
		string2Panel.getJComboBox().addActionListener(this);
		string3Panel.getJComboBox().addActionListener(this);
		string4Panel.getJComboBox().addActionListener(this);
		string5Panel.getJComboBox().addActionListener(this);
		string6Panel.getJComboBox().addActionListener(this);
	}

	public void initializeBorder(boolean boundsTestingEnabled) {
		if (boundsTestingEnabled) {
			border = BorderFactory.createLineBorder(Color.orange, 3);
			this.setBorder(border);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == string1Panel.getJComboBox()) {
			System.out.println(string1Panel.getJComboBox().getSelectedItem());
		}
		if (e.getSource() == string2Panel.getJComboBox()) {
			System.out.println(string2Panel.getJComboBox().getSelectedItem());
		}
		if (e.getSource() == string3Panel.getJComboBox()) {
			System.out.println(string3Panel.getJComboBox().getSelectedItem());
		}
		if (e.getSource() == string4Panel.getJComboBox()) {
			System.out.println(string4Panel.getJComboBox().getSelectedItem());
		}
		if (e.getSource() == string5Panel.getJComboBox()) {
			System.out.println(string5Panel.getJComboBox().getSelectedItem());
		}
		if (e.getSource() == string6Panel.getJComboBox()) {
			System.out.println(string6Panel.getJComboBox().getSelectedItem());
		}
		
	}
}
