package robo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JToolTip;

public class CMenuItem extends JMenuItem{
	public CMenuItem(String string) {
		this.setText(string);
		this.setPreferredSize(new Dimension(CTheme.widthMenu,100));
	}
	
	
    public JToolTip createToolTip() {
            JToolTip tip = super.createToolTip();
            tip.setForeground(CTheme.tipFrontColor);
            tip.setBackground(CTheme.tipBackColor);
            tip.setFont(CTheme.textFont);
            return tip;
          }
        
}
