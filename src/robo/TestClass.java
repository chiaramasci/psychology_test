package robo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*CLASS OF THE TAB 'TEST
 * 
 * */

public class TestClass extends JPanel implements ActionListener{
	private static int count;
	private static int[] answers = {0,0,0,0,0,0,0,0,0,0};
	
	private static JPanel startPanel;
	private static JButton startButton;
	private static JLabel desc;
	private static QuestionClass q1;
	private static QuestionClass q2;
	private static QuestionClass q3;
	private static QuestionClass q4;
	private static QuestionClass q5;
	private static QuestionClass q6;
	private static QuestionClass q7;
	private static QuestionClass q8;
	private static QuestionClass q9;
	private static QuestionClass q10;
	private static JPanel container;
	
	public TestClass() {
		count = 0;
		startPanel = new JPanel();
		startButton = new JButton("START");
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		startButton.addActionListener(this);
		desc = new JLabel("<html>You have only to reply to 10 questions. <br/> Aren't you curious?</html>",SwingConstants.CENTER);
		desc.setAlignmentX(Component.CENTER_ALIGNMENT);
		desc.setFont(CTheme.textFont);
		desc.setForeground(CTheme.textColor);
		startPanel.add(desc);
		startPanel.add(startButton);
		startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.PAGE_AXIS));
		startPanel.setBackground(CTheme.wbackgroundColor);
		
		//prepares container
		container = new JPanel();
		
		//creates questions
		q1 = new QuestionClass("Extraverted, enthusiastic");
		q2 = new QuestionClass("Critical, quarrelsome");
		q3 = new QuestionClass("Dependable, self-disciplined");
		q4 = new QuestionClass("Anxious, easily upset");
		q5 = new QuestionClass("Open to new experiences, complex");
		q6 = new QuestionClass("Reserved, quiet");
		q7 = new QuestionClass("Sympathetic, warm");
		q8 = new QuestionClass("Disorganized, careless");
		q9 = new QuestionClass("Calm, emotionally stable");	
		q10 = new QuestionClass("Conventional, uncreative");
		
		//sets background
		this.setBackground(CTheme.wbackgroundColor);
		container.setBackground(CTheme.wbackgroundColor);
		
		//add components
		container.add(startPanel);
		container.add(q1);
		container.add(q2);
		container.add(q3);
		container.add(q4);
		container.add(q5);
		container.add(q6);
		container.add(q7);
		container.add(q8);
		container.add(q9);
		container.add(q10);
		
		container.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
		
		this.add(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//test starts. First question displayed. Count updated.
		startPanel.setVisible(false);
		count++;
		q1.setVis(true);	
	}
	
	//at which question are we?
	public static int getCount() {
		return count;
	}
	
	//store answers
	public static void updateAnswers(int value) {
		answers[count - 1] = value; //count= 0 is the start page
		if((count - 1) < 10)
			System.out.println(answers[0] + " " + answers[1] + " " + answers[2] + " " + answers[3] + " " + answers[4] + " " + answers[5] + " " + answers[6] + " " + answers[7] + " " + answers[8] + " " + answers[9]);
	}
	
	//calculate results
	public static double[] calculateResult(int[] answers) {
		double[] results = {0.0,0.0,0.0,0.0,0.0};
		//reverse 6,2,8,4,10 (remember index starts from zero)
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 1) {
				//the function y=-x + 8 is used to reverse
				answers[i] = 8 - answers[i];
			}
		}
		
		//sum for average
		double[] sums = {answers[0] + answers[5],answers[6] + answers[1],answers[2] + answers[7],answers[8] + answers[3],answers[5] + answers[9]};
		//average
		for (int i = 0; i < 5; i++) {
			results[i] = sums[i]/2.0;
		}
		
		System.out.println("RESULTS: " + results[0]);
		
		//results[0] extraversion
		//results[1] agreeableness
		//results[2] conscientiousness
		//results[3] emotional stability
		//results[4] openness to experiences
		return results;}
	
	//visibility of questions (started from a QuestionClass)
	public static void changeQuestion(String oper) {
		
		if(count < 11 && count > -1) {
		if(oper == "next") 
			count++;
		else if(oper == "prev")
			count--;
		
		if(count == 1) {
			q1.setVis(true);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		} else if(count == 2) {
			q1.setVis(false);
			q2.setVis(true);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		}else if(count == 3) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(true);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		} else if(count == 4) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(true);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		}else if(count == 5) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(true);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		}else if(count == 6) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(true);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		}else if(count == 7) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(true);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(false);
		}else if(count == 8) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(true);
			q9.setVis(false);
			q10.setVis(false);
		}else if(count == 9) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(true);
			q10.setVis(false);
		}else if(count == 10) {
			q1.setVis(false);
			q2.setVis(false);
			q3.setVis(false);
			q4.setVis(false);
			q5.setVis(false);
			q6.setVis(false);
			q7.setVis(false);
			q8.setVis(false);
			q9.setVis(false);
			q10.setVis(true);
		}else if(count == 11) {
			q10.setVis(false);
			container.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
			
			//calculate results
			double[] results = calculateResult(answers);
			System.out.println(results[0]);
			
			//show results
			container.removeAll();
			container.revalidate();
			ResultTest resultScreen = new ResultTest(results,true);
			container.add(resultScreen);
			container.repaint();
			
		}
		
		}		
	}
	
	public static void resetTest() {
		container.removeAll();
		container.revalidate();
		container.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
		container.add(startPanel);
		container.add(q1);
		container.add(q2);
		container.add(q3);
		container.add(q4);
		container.add(q5);
		container.add(q6);
		container.add(q7);
		container.add(q8);
		container.add(q9);
		container.add(q10);
		container.repaint();
		
		count = 0;
		startPanel.setVisible(true);
		
		q1.setVis(false);
		q2.setVis(false);
		q3.setVis(false);
		q4.setVis(false);
		q5.setVis(false);
		q6.setVis(false);
		q7.setVis(false);
		q8.setVis(false);
		q9.setVis(false);
		q10.setVis(false);
	}
}
