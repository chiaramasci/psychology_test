package robo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainClass {
	
	private static String nameUser;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		//TITLE
		JLabel title = new JLabel("Tisi personality test");
		title.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
		title.setFont(CTheme.titleFont);
		
		//CREATE MENU
		CMenuBar menubar = new CMenuBar();
		menubar.setVisible(false);
		
		//BUTTON MENU
		JButton menuShow = new JButton("");
		menuShow.setFont(CTheme.seltabFont);
		menuShow.setIcon(new ImageIcon("src/robo/menu.png"));
		menuShow.setPreferredSize(new Dimension(CTheme.widthMenu,menuShow.getHeight()));
		menuShow.setFocusPainted(false);
		menuShow.setOpaque(true);
		menuShow.setBorderPainted(false);
		menuShow.setBackground(CTheme.dbackgroundColor);
		menuShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(menubar.isVisible()) {
					menubar.setVisible(false);
					menuShow.setBackground(CTheme.dbackgroundColor);}
				else if(!menubar.isVisible()) {
					menubar.setVisible(true);
					menuShow.setBackground(CTheme.lbackgroundColor);}
				
			}});
		
		//CREATE HEADER
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		header.add(title,BorderLayout.WEST);
		header.add(menuShow, BorderLayout.EAST);
		header.setBackground(CTheme.dbackgroundColor);
		header.setPreferredSize(new Dimension(700,50));
		
		//TABBED PANE
		JTabbedPane tbp = new JTabbedPane();
		tbp.setUI(new CTabbedPane());
		tbp.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 10));
		TestClass test = new TestClass();
        SummaryClass summary = new SummaryClass();
        SearchClass search = new SearchClass();
        tbp.addTab("TEST", test);
        tbp.addTab("SUMMARY", summary);
        tbp.addTab("SEARCH", search);
        tbp.setPreferredSize(new Dimension(700,650));
        
      //CONTAINER ELEMENTS
      JPanel containerEl = new JPanel();
      containerEl.setLayout(new BorderLayout());
      containerEl.add(header,BorderLayout.NORTH);
      containerEl.add(tbp,BorderLayout.CENTER);
      containerEl.add(menubar,BorderLayout.EAST);
      containerEl.setBackground(CTheme.dbackgroundColor);
        
		//CREATE FRAME
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(containerEl);
		frame.setPreferredSize(new Dimension(720,750));
		frame.pack();
		frame.setVisible(true);
//		frame.setJMenuBar(menubar);
		frame.getContentPane().setBackground(CTheme.dbackgroundColor);
		
		//TUTORIAL
		COptionPane pane = new COptionPane();
		String name = pane.showInputDialog(frame, "What's your name?","Introduce yourself", JOptionPane.PLAIN_MESSAGE);
		
		if(name == null)
			name = "";
		
		nameUser = name;
		
		TutorialClass tutorial = new TutorialClass(name);
	}
	
	public static String getNameUser(){
		return nameUser;
	}
	
}
