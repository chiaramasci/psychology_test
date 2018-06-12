package robo;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutClass extends COptionPane{
	public AboutClass() {
		JPanel aboutPan = new JPanel();
		JLabel aboutNameLab = new JLabel("About", SwingConstants.CENTER);
		aboutNameLab.setFont(CTheme.titleFont);
		aboutNameLab.setForeground(CTheme.titleColor);
		
		JPanel descriptionPanel = new JPanel();
		JLabel devLab = new JLabel("Developer: Chiara Masci");
		JLabel classLab = new JLabel("Number of classes: 27");
		JLabel methLab = new JLabel("Number of methods: 67");
		JLabel lineLab = new JLabel("Total lines: 1784");
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel,BoxLayout.PAGE_AXIS));
		
		devLab.setFont(CTheme.textFont);
		devLab.setForeground(CTheme.textColor);
		classLab.setFont(CTheme.textFont);
		classLab.setForeground(CTheme.textColor);
		methLab.setFont(CTheme.textFont);
		methLab.setForeground(CTheme.textColor);
		lineLab.setFont(CTheme.textFont);
		lineLab.setForeground(CTheme.textColor);
		
		descriptionPanel.add(devLab);
		descriptionPanel.add(classLab);
		descriptionPanel.add(methLab);
		descriptionPanel.add(lineLab);
		
		aboutPan.add(aboutNameLab);
		aboutPan.add(descriptionPanel);
		aboutPan.setLayout(new BoxLayout(aboutPan,BoxLayout.PAGE_AXIS));
		
		COptionPane aboutOption = new COptionPane(aboutPan);
		aboutOption.showMessageDialog(aboutOption, aboutPan, "Begin",JOptionPane.PLAIN_MESSAGE);
	}
}
