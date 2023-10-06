package ui;

import java.awt.Image;
import javax.swing.ImageIcon;

public final class Iconify {
	
	static ImageIcon icon;
	
	public static ImageIcon iconify(String iconName, int width, int height) {
		
		icon = new ImageIcon(iconName);
		
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		return newIcon;
	}
	
}