package robo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class COptionPane extends JOptionPane{
	//TO DO: UI MANAGEMENT
	
	public COptionPane() {
		UIManager UI = new UIManager();
		 UI.put("OptionPane.background", CTheme.wbackgroundColor);
		 UI.put("Panel.background", CTheme.wbackgroundColor);
		 UI.put("OptionPane.messageFont", CTheme.textFont);	 
	}
	
	public COptionPane(JComponent component) {
		UIManager UI = new UIManager();
		 UI.put("OptionPane.background", CTheme.wbackgroundColor);
		 UI.put("Panel.background", CTheme.wbackgroundColor);
		 UI.put("OptionPane.messageFont", CTheme.textFont);
		 
		
		 
		 this.add(component);
	}
}
