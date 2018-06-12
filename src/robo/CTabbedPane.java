package robo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/*CLASS THAT DESIGNS THE APPEARANCE OF THE TABS
 * 
 * */

public class CTabbedPane extends BasicTabbedPaneUI{
	private Color selectColor;
    private Color deSelectColor;
    private int anchoCarpetas = 18;
    private Polygon shape;

    public static ComponentUI createUI(JComponent c) {
        return new CTabbedPane();
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        selectColor = CTheme.wbackgroundColor;
        deSelectColor = CTheme.dbackgroundColor;
        tabAreaInsets.right = anchoCarpetas;
    }

   
    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2D = (Graphics2D) g;
        int xp[] = {x,x+w,x+w,x}; 
        int yp[] = {y+h,y+h,y+h+3,y+h+3};
        
        shape = new Polygon(xp, yp, xp.length);
        if (isSelected) {
            g2D.setPaint(selectColor);
        } else {
            if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                g2D.setColor(deSelectColor);
      
            } 
        }
       
        g2D.fill(shape);
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(CTheme.seltabFont);
        g2.setColor(CTheme.wbackgroundColor);
    }
        
       
   

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        if (tabPane.hasFocus() && isSelected) {
            g.setColor(selectColor);
            g.drawPolygon(shape);
        }
    }

      
    //delete the gray padding
    private final Insets borderInsets = new Insets(3, 0, 0, 0);
    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
    }
    @Override
    protected Insets getContentBorderInsets(int tabPlacement) {
        return borderInsets;
    }
}
