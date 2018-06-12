package robo;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicHTML;

public class CButton extends JButton{
	private String text;
	
	public CButton(String buttonText) {
//		this.setUI(new CButtonUI());
		text = buttonText;
	}
	
	class CButtonUI extends BasicButtonUI{
		private Rectangle viewRect = new Rectangle();
	    private Rectangle textRect = new Rectangle();
	    private Rectangle iconRect = new Rectangle();

	    public void paint(Graphics g, JComponent c)
	    {
	        AbstractButton b = (AbstractButton) c;
	        ButtonModel model = b.getModel();

	        int bWidth = b.getWidth() + 20 + 20;
	        int bHeight = b.getHeight() + 20 + 2;
	        FontMetrics bFontMetrics = b.getFontMetrics(getFont());


	        // perform UI specific press action, e.g. Windows L&F shifts text
	        if (model.isArmed() && model.isPressed()) {
	            paintButtonPressed(g,b);
	        }

	        //paint text
	        paintText(g, b, textRect, text);
	         
	        b.setBackground(CTheme.dbackgroundColor);
	        b.setBounds(b.getX(), b.getY(), bWidth, bHeight);
	        

	        if (b.isFocusPainted() && b.hasFocus()) {
	            // paint UI specific focus
	            paintFocus(g,b,viewRect,textRect,iconRect);
	        }
	    }
	    
	    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
	        paintText(g, (JComponent)b, textRect, text);
	    }
	    

	}
}
