package robo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class CMenuBar extends JMenuBar implements ActionListener{
	//menu of the program
	TutorialClass tutorialAct;
	AboutClass aboutAct;
	CMenuItem reset,about,tutorial,exit;
	KeyStroke keyStrokeToAbout, keyStrokeToTutorial, keyStrokeToReset, keyStrokeToExit;
		
	CMenuBar(){
		keyStrokeToAbout = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
		keyStrokeToTutorial = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK);
		keyStrokeToReset = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
		keyStrokeToExit = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
		
		about = new CMenuItem("About");
		about.setActionCommand("about");
		about.setToolTipText("Know more about the software and developer");
		about.addActionListener(this);
		about.setAccelerator(keyStrokeToAbout);
		about.setBackground(CTheme.lbackgroundColor);
		
		tutorial = new CMenuItem("Tutorial");
		tutorial.setActionCommand("tutorial");
		tutorial.setToolTipText("Doubts?");
		tutorial.addActionListener(this);
		tutorial.setAccelerator(keyStrokeToTutorial);
		tutorial.setBackground(CTheme.lbackgroundColor);
		
		reset = new CMenuItem("Reset");
		reset.setActionCommand("reset");
		reset.setToolTipText("reset collected data");
		reset.addActionListener(this);
		reset.setAccelerator(keyStrokeToReset);
		reset.setBackground(CTheme.lbackgroundColor);
		
		exit = new CMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.setToolTipText("Close program");
		exit.addActionListener(this);
		exit.setAccelerator(keyStrokeToExit);
		exit.setBackground(CTheme.lbackgroundColor);
		
		this.setBackground(CTheme.lbackgroundColor);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(about);
		this.add(tutorial);
		this.add(reset);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command == "about")
			aboutAct = new AboutClass();
		if(command == "tutorial")
			tutorialAct = new TutorialClass();
		if(command == "exit")
			System.exit(0);
		if(command == "reset") {
			JPanel resetPan = new JPanel();
			JLabel resetLab = new JLabel("Warning");
			resetLab.setFont(CTheme.titleFont);
			resetLab.setForeground(CTheme.titleColor);
			resetLab.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLabel resetTextLab = new JLabel("<html>All the data will be deleted. Continue?</html>");
			resetTextLab.setAlignmentX(Component.CENTER_ALIGNMENT);
			resetTextLab.setFont(CTheme.textFont);
			resetTextLab.setForeground(CTheme.textColor);
			resetPan.setLayout(new BoxLayout(resetPan,BoxLayout.PAGE_AXIS));
			resetPan.add(resetLab);
			resetPan.add(resetTextLab);
			
			JOptionPane confirmation = new JOptionPane();
			int response = confirmation.showConfirmDialog(confirmation, resetPan, "All the data will be deleted. Continue?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(response == JOptionPane.OK_OPTION)
				DataClass.resetData();
		}
			
		
	}
	

}
