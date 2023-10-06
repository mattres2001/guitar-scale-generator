package ui;

import java.util.Map;

import model.Constants;

import java.awt.Color;
import java.awt.Graphics;

public class Frets {

	public static int DOT_RADIUS = 10;
	public static int Y_ORIGIN_POS = 108; // decrement by 21 each string
	public static int Y_DECREMENT = 21;
	public static int X_POSITIONS[] = { 
			96, 149, 235, 320, 394, 470, 
			536, 603, 661, 721, 774, 824, 
			875, 918, 961, 1006, 1041, 1080, 
			1112, 1147, 1174, 1207, 1233, 1258
		};
	
	public static void drawFrets(Map<Integer, boolean[]> fretPositions, Graphics g) {
		
		g.setColor(Color.gray);
		
		for (int i = 0; i < Constants.STRINGS; i++) {
			for (int j = 0; j < Constants.FRETS; j++) {
				if (fretPositions.get(i)[j] == true)
					g.fillOval(X_POSITIONS[j], Y_ORIGIN_POS + (Y_DECREMENT * i), DOT_RADIUS, DOT_RADIUS);
			}
		}
	}
	
}
