package robo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class QuestionClass extends JPanel implements ActionListener, ItemListener{
	private CRadioButton r1;
	private CRadioButton r2;
	private CRadioButton r3;
	private CRadioButton r4;
	private CRadioButton r5;
	private CRadioButton r6;
	private CRadioButton r7;
	private ButtonGroup g;
	private JButton next;
	private JButton prev;
	private JLabel valueSelected;
	
	public QuestionClass(String question) {
		JPanel questionP = new JPanel();
		JLabel questionL = new JLabel(question);
		JLabel headerL = new JLabel("Are you...?",SwingConstants.CENTER);
		headerL.setAlignmentX(Component.CENTER_ALIGNMENT);
		questionL.setAlignmentX(Component.CENTER_ALIGNMENT);
		headerL.setFont(CTheme.textFont);
		questionL.setFont(CTheme.titleFont);
		questionP.add(headerL);
		questionP.add(questionL);
		questionP.setLayout(new BoxLayout(questionP,BoxLayout.PAGE_AXIS));
		questionP.setBackground(CTheme.wbackgroundColor);
		this.setBackground(CTheme.lbackgroundColor);
		
		r1 = new CRadioButton();
		r2 = new CRadioButton();
		r3 = new CRadioButton();
		r4 = new CRadioButton();
		r5 = new CRadioButton();
		r6 = new CRadioButton();
		r7 = new CRadioButton();
		r4.setSelected(true); //by default the middle one is selected
		
		//values of radio buttons
		r1.setActionCommand("1");
		r2.setActionCommand("2");
		r3.setActionCommand("3");
		r4.setActionCommand("4");
		r5.setActionCommand("5");
		r6.setActionCommand("6");
		r7.setActionCommand("7");
		
		//item listeners
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
		r4.addItemListener(this);
		r5.addItemListener(this);
		r6.addItemListener(this);
		r7.addItemListener(this);
		
		g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		g.add(r3);
		g.add(r4);
		g.add(r5);
		g.add(r6);
		g.add(r7);
		
		JPanel buttonGroup = new JPanel();
		buttonGroup.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		buttonGroup.setBackground(CTheme.wbackgroundColor);
		buttonGroup.add(r1);
		buttonGroup.add(r2);
		buttonGroup.add(r3);
		buttonGroup.add(r4);
		buttonGroup.add(r5);
		buttonGroup.add(r6);
		buttonGroup.add(r7);
		
		//prev and next buttons
		JPanel prevnextPanel = new JPanel();
		prevnextPanel.setBackground(CTheme.wbackgroundColor);
		next = new JButton("next");
		next.setActionCommand("next");
		prev = new JButton("previous");
		prev.setActionCommand("prev");
		next.addActionListener(this);
		prev.addActionListener(this);
		prevnextPanel.add(prev);
		prevnextPanel.add(next);
		
		//value selected label
		JPanel valueSelP = new JPanel();
		valueSelected = new JLabel();
		setValueLab();
		valueSelP.add(valueSelected);
		valueSelP.setBackground(CTheme.wbackgroundColor);
		valueSelP.setForeground(CTheme.lbackgroundColor);
		valueSelP.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
			
		//adds components
		this.add(questionP);
		this.add(buttonGroup);
		this.add(valueSelP);
		this.add(prevnextPanel);
		
		//is TestClass that decides if the current question has to be shown
		this.setVisible(false);
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		this.setBackground(CTheme.wbackgroundColor);
	}
	
	public void setVis(boolean visible) {
		this.setVisible(visible);
	}
	
	public void setValueLab() {
		String[] textLabel = {"Disagree Strongly","Disagree moderately","Disagree a little","Neither agree nor disagree","Agree a little","Agree moderately","Agree strongly"};
		System.out.println(g.getSelection().getActionCommand());
		valueSelected.setText(textLabel[Integer.parseInt(g.getSelection().getActionCommand()) - 1]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//checks if count is 1 or 10 (first question or last) and modifies buttons accordingly
		int count = TestClass.getCount();
		if (count == 1)
			prev.setEnabled(false);
		else if(count == 10)
			next.setText("See result");
		
		if(count < 11) {
		//gets answer and "saves it" in TestClass
		int answer = Integer.parseInt(g.getSelection().getActionCommand());
		TestClass.updateAnswers(answer);
		}
		
		//moves on to the next or previous question
		String action = e.getActionCommand();
		TestClass.changeQuestion(action);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		setValueLab();
	}

}
