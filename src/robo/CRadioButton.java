package robo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JRadioButton;

public class CRadioButton extends JRadioButton{
	Color selectedColor = CTheme.lbackgroundColor;
	Color defaultColor = CTheme.wbackgroundColor;
	
	public CRadioButton(){
		this.setIcon(new DefaultIcon());
		this.setSelectedIcon(new PressedIcon());
	}
	
	class PressedIcon implements Icon{
		@Override
	    public int getIconHeight() { return 15; }
	  
		@Override
	    public int getIconWidth() { return 15; }
	  
	    @Override
	    public void paintIcon(Component c, Graphics g, int x, int y)
	    {
	    		Graphics2D g2 = (Graphics2D) g;
	    	
	    		//stroke
	    		Stroke oldStroke = g2.getStroke();
	    		g2.setStroke(new BasicStroke(4));
	    		g2.setColor(selectedColor);
	    		g2.drawRect(x, y, getIconWidth(), getIconHeight());
	    		g2.setStroke(oldStroke);
	    		
	    		//fill
	        Color oldColor = g2.getColor();
	        g2.setColor(selectedColor);
	        g2.fillRect(x, y, getIconWidth(), getIconHeight());
	        g2.setColor(oldColor); //in case there are problems, the previous color is rendered
	    }	
		}
	
	class DefaultIcon implements Icon{
		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g;
			
			Stroke oldStroke = g2.getStroke();
			Color oldColor = g2.getColor();
			
			//stroke
			g2.setStroke(new BasicStroke(4));
			g2.setColor(selectedColor);
			g2.drawRect(x, y, getIconWidth(), getIconHeight());
			g2.setStroke(oldStroke);//in case there are problems, the previous stroke is rendered
			
			//fill
			g2.setColor(defaultColor);
			g2.fillRect(x, y, getIconWidth(), getIconHeight());
			g2.setColor(oldColor); //in case there are problems, the default color is rendered
			
		}

		@Override
		public int getIconWidth() {
			return 15;
		}

		@Override
		public int getIconHeight() {
			return 15;
		}
		
	}

}
