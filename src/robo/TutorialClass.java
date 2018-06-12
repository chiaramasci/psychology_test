package robo;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TutorialClass {
	public TutorialClass(String name) {
		int tutorial = welcomeScreen(name);
		
		if(tutorial == JOptionPane.YES_OPTION) {
			tisiScreen();
			programScreen();
		}
			
	}
	
	public TutorialClass() {
		tisiScreen();
		programScreen();
	}
	
	public int welcomeScreen(String name) {
		JPanel welcomePan = new JPanel();
		JLabel welcomeNameLab = new JLabel("Welcome " + name);
		welcomeNameLab.setFont(CTheme.titleFont);
		welcomeNameLab.setForeground(CTheme.titleColor);
		JLabel welcomeTextLab = new JLabel("<html>Are you new? You can continue with the tutorial or skip it <br /> PS: you can also see it later clicking on Tutorial in the menu</html>");
		welcomeTextLab.setFont(CTheme.textFont);
		welcomeTextLab.setForeground(CTheme.textColor);
		welcomePan.add(welcomeNameLab);
		welcomePan.add(welcomeTextLab);
		welcomePan.setLayout(new BoxLayout(welcomePan,BoxLayout.PAGE_AXIS));
		
		COptionPane welcomeOption = new COptionPane(welcomePan);
		int response = welcomeOption.showConfirmDialog(welcomeOption, welcomePan, "Begin", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		return response;
	}
	
	public void tisiScreen() {
		JPanel tisiPan = new JPanel();
		JLabel tisiNameLab = new JLabel("TISI personality test");
		tisiNameLab.setFont(CTheme.titleFont);
		tisiNameLab.setForeground(CTheme.titleColor);
		JLabel tisiTextLab = new JLabel("<html>This test assesses the personality under the following criteria: <br />extraversion, agreeableness, conscientiousness, emotional stability and openness.</html>");
		tisiTextLab.setFont(CTheme.textFont);
		tisiTextLab.setForeground(CTheme.textColor);
		tisiPan.add(tisiNameLab);
		tisiPan.add(tisiTextLab);
		tisiPan.setLayout(new BoxLayout(tisiPan,BoxLayout.PAGE_AXIS));
		
		COptionPane welcomeOption = new COptionPane(tisiPan);
		welcomeOption.showMessageDialog(welcomeOption, tisiPan, "Begin",JOptionPane.PLAIN_MESSAGE);
	}
	
	public void programScreen() {
		JPanel progPan = new JPanel();
		JLabel progNameLab = new JLabel("The software");
		progNameLab.setFont(CTheme.titleFont);
		progNameLab.setForeground(CTheme.titleColor);
		JLabel progTextLab = new JLabel("<html>In this software you can take the test and save your result, <br />see a summary of the results of the other users <br /> or see the score of a specific person</html>");
		progTextLab.setFont(CTheme.textFont);
		progTextLab.setForeground(CTheme.textColor);
		progPan.add(progNameLab);
		progPan.add(progTextLab);
		progPan.setLayout(new BoxLayout(progPan,BoxLayout.PAGE_AXIS));
		
		COptionPane programOption = new COptionPane(progPan);
		programOption.showMessageDialog(programOption, progPan, "Begin",JOptionPane.PLAIN_MESSAGE);
	}
}
