package robo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SummaryClass extends JPanel{
	private static JPanel container;
	private static SummarySingle extraversion;
	private static SummarySingle agreeableness;
	private static SummarySingle conscientiousness;
	private static SummarySingle emstability;
	private static SummarySingle openness;
	private static SummaryCharClass summ;
	private static GridBagConstraints c;
	
	public SummaryClass() {
		container = new JPanel();
		container.setLayout(new GridLayout(2,3));
		container.setBackground(CTheme.wbackgroundColor);
		container.setPreferredSize(new Dimension(700,550));
		
		extraversion = new SummarySingle("extraversion",0);
		agreeableness = new SummarySingle("agreeableness",1);
		conscientiousness = new SummarySingle("conscientiousness",2);
		emstability = new SummarySingle("emotional stability",3);
		openness = new SummarySingle("openness",4);
		
		extraversion.changeLayout(4);
		agreeableness.changeLayout(4);
		conscientiousness.changeLayout(4);
		emstability.changeLayout(4);
		openness.changeLayout(4);
			
		summ = new SummaryCharClass();
		
		container.add(extraversion);
		container.add(agreeableness);
		container.add(conscientiousness);
		container.add(emstability);
		container.add(openness);
		
		this.add(container);
		this.add(summ);
		this.setBackground(CTheme.wbackgroundColor);
	}
	
	//update graphs after save result (from dataclass)
	public static void updateSummary() {
		container.removeAll();
		extraversion = new SummarySingle("extraversion",0);
		agreeableness = new SummarySingle("agreeableness",1);
		conscientiousness = new SummarySingle("conscientiousness",2);
		emstability = new SummarySingle("emotional stability",3);
		openness = new SummarySingle("openness",4);
		
		extraversion.changeLayout(4);
		agreeableness.changeLayout(4);
		conscientiousness.changeLayout(4);
		emstability.changeLayout(4);
		openness.changeLayout(4);
			
		summ = new SummaryCharClass();
		
		container.add(extraversion);
		container.add(agreeableness);
		container.add(conscientiousness);
		container.add(emstability);
		container.add(openness);
		container.repaint();
	}
	
	//add update method to see checks and show/hide histograms
	public static void charVisibility(boolean[] checks) {
		container.removeAll();
		container.revalidate();
		
		int numOfChecks = 0;
		for(int i = 0; i< checks.length; i++) {
			if(checks[i]) {
				numOfChecks +=1;
				
				if(i == 0)
					container.add(extraversion);
				if(i == 1)
					container.add(agreeableness);
				if(i == 2)
					container.add(conscientiousness);
				if(i == 3)
					container.add(emstability);
				if(i == 4)
					container.add(openness);
			}
		}
		
		//depending on the number of true, set dimensions
		extraversion.changeLayout(numOfChecks);
		agreeableness.changeLayout(numOfChecks);
		conscientiousness.changeLayout(numOfChecks);
		emstability.changeLayout(numOfChecks);
		openness.changeLayout(numOfChecks);
		
		container.repaint();
	}
}
