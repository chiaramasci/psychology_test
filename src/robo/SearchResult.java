package robo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*CLASS OF THE ELEMENT OF THE LIST OF THE RESULT OF THE SEARCH IN THE TAB 'SEARCH
 * 
 * */

public class SearchResult extends JPanel implements MouseListener{
	private JPanel container;
	private JLabel username;
	private JPanel values;
	private JLabel extraversion;
	private JLabel agreeableness;
	private JLabel conscientiousness;
	private JLabel emstability;
	private JLabel openness;
	
	private double[] resultList = {0.0,0.0,0.0,0.0,0.0};
	
	public SearchResult(String[] result) {
		//storing values
		for(int i = 0; i < 5; i++) {
			resultList[i] = Double.parseDouble(result[i + 1]);
		}
		
		//add listener
		this.addMouseListener(this);
		
		//creating labels
		username = new JLabel(result[0]);
		extraversion = new JLabel(new SquareIcon(result[1]));
		agreeableness = new JLabel(new SquareIcon(result[2]));
		conscientiousness = new JLabel(new SquareIcon(result[3]));
		emstability = new JLabel(new SquareIcon(result[4]));
		openness = new JLabel(new SquareIcon(result[5]));
		
		//container for icons
		JPanel iconContainer = new JPanel();
		iconContainer.add(extraversion);
		iconContainer.add(agreeableness);
		iconContainer.add(conscientiousness);
		iconContainer.add(emstability);
		iconContainer.add(openness);
		iconContainer.setBackground(CTheme.lbackgroundColor);
		
		//add components
		this.add(username);
		this.add(iconContainer);
		
		//layout and size
		this.setPreferredSize(new Dimension(400,40));
		this.setLayout(new GridLayout(1,2));
		this.setBackground(CTheme.lbackgroundColor);
	}
	
	public class SquareIcon implements Icon{
		private double num;
		private String numStr;
		private final int dimIcon = 20;
		private final Color LOW_COLOR = CTheme.lowColor;
		private final Color MED_COLOR = CTheme.medColor;
		private final Color HIGH_COLOR = CTheme.highColor;
		private Color iconColor;
		private Color textColor;
		
		SquareIcon(String value){
			numStr = value;
			num = Double.parseDouble(value);
			String lmh = DataClass.lmhData(num);
			
			if(lmh == "low") {
				iconColor = LOW_COLOR;
				textColor = HIGH_COLOR;}
			else if(lmh == "medium") {
				iconColor = MED_COLOR;
				textColor = HIGH_COLOR;}
			else if(lmh == "high") {
				iconColor = HIGH_COLOR;
				textColor = LOW_COLOR;}
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(iconColor);
			g.fillRect(x, y, getIconWidth(), getIconHeight());
			
			int xx = this.getIconWidth();
	        int yy = this.getIconHeight();
	        int w2 = g.getFontMetrics().stringWidth(numStr) / 2;
	        int h2 = g.getFontMetrics().getDescent();
	        g.setColor(textColor);
	        g.drawString(numStr, xx / 2 - w2, yy / 2 + h2);
			
		}

		@Override
		public int getIconWidth() {
			return dimIcon;
		}

		@Override
		public int getIconHeight() {
			return dimIcon;
		}}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("nananan");
		COptionPane pane = new COptionPane();
		ResultTest result = new ResultTest(resultList,false);
		pane.add(result);
		pane.showConfirmDialog(pane, result, "Results", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
