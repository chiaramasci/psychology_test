package robo;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//PANEL TO SELECT WHICH GRAPHS TO SHOW IN SUMMARY TAB

public class SummaryCharClass extends JPanel implements ItemListener{
	private boolean[] checks = {true,true,true,true,true};
	private CCheckBox extraversion;
	private CCheckBox agreeableness;
	private CCheckBox conscientiousness;
	private CCheckBox emstability;
	private CCheckBox openness;
	
	public SummaryCharClass() {
		extraversion = new CCheckBox("extraversion", true);
		agreeableness = new CCheckBox("agreeableness", true);
		conscientiousness = new CCheckBox("conscientiousness", true);
		emstability = new CCheckBox("emstability", true);
		openness = new CCheckBox("openness", true);
		
		extraversion.addItemListener(this);
		extraversion.setName("extraversion");
		agreeableness.addItemListener(this);
		agreeableness.setName("agreeableness");
		conscientiousness.addItemListener(this);
		conscientiousness.setActionCommand("conscientiousness");
		emstability.addItemListener(this);
		emstability.setName("emstability");
		openness.addItemListener(this);
		openness.setName("openness");
		
		extraversion.setBackground(CTheme.wbackgroundColor);
		agreeableness.setBackground(CTheme.wbackgroundColor);
		conscientiousness.setBackground(CTheme.wbackgroundColor);
		emstability.setBackground(CTheme.wbackgroundColor);
		openness.setBackground(CTheme.wbackgroundColor);
		
		this.add(extraversion);
		this.add(agreeableness);
		this.add(conscientiousness);
		this.add(emstability);
		this.add(openness);

		this.setBackground(CTheme.wbackgroundColor);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		boolean selected = e.getStateChange() == ItemEvent.SELECTED ? true : false;
		JCheckBox check = (JCheckBox)e.getSource();
        String ch = check.getName();
		
        if(ch == "extraversion")
        		checks[0] = selected;
        else if(ch == "agreeableness")
        		checks[1] = selected;
        else if(ch == "conscientiousness")
    			checks[2] = selected;
        else if(ch == "emstability")
    			checks[3] = selected;
        else if(ch == "openness")
    			checks[4] = selected;
        	
        //add update of SummaryClass
        SummaryClass.charVisibility(checks);
	}

	
}
