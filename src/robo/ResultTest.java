package robo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*CLASS THAT DISPLAYS THE RESULT OF THE TEST
 * 
 * */
public class ResultTest extends JPanel implements ActionListener{
	
	private double[] resultsList;
	private JPanel lmhPan;
	private JPanel lowPan;
	private JLabel extraversion;
	private JLabel agreeableness;
	private JLabel conscientiousness;
	private JLabel emstability;
	private JLabel openness;
	private JButton saveButton;
	private JButton redoButton;
	private final String[] LABELS = {"extraversion","agreeableness", "conscientiousness","emotional stability","openness"};
	
	ResultTest(double[] results, boolean save){
		resultsList = results;
		
		//title
		JLabel title = new JLabel("Results", SwingConstants.CENTER);
		title.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
		title.setFont(CTheme.titleFont);
		
		//histogram
		HistogramClass histogram = new HistogramClass(results,LABELS,"result");
		
		//labels high, medium, low parameters
		lmhPan = new JPanel();
		lmhPan.setLayout(new GridLayout(5,2));
		
		extraversion = new JLabel("extraversion");
		agreeableness = new JLabel("agreeableness");
		conscientiousness = new JLabel("conscientiousness");
		emstability = new JLabel("emotional stability");
		openness = new JLabel("openness");
		
		
		//low pan
		lowPan = new JPanel();
		lowPan.setLayout(new BoxLayout(lowPan,BoxLayout.LINE_AXIS));
		if(save) {
			saveButton = new JButton("save");
			saveButton.addActionListener(this);
			saveButton.setActionCommand("save");
			lowPan.add(saveButton);
			
			redoButton = new JButton("redo");
			redoButton.addActionListener(this);
			redoButton.setActionCommand("redo");
			lowPan.add(redoButton);
		}
		
		this.setLayout(new BorderLayout());
		this.setBackground(CTheme.wbackgroundColor);
		
		//add components
		this.add(title,BorderLayout.PAGE_START);
		this.add(histogram,BorderLayout.CENTER);
		this.add(lowPan,BorderLayout.PAGE_END);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "save") {
			
		COptionPane savePane = new COptionPane();
		int saveDec = savePane.showConfirmDialog(savePane, "do you want to save your result?", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		String nickname;
		
		if(saveDec == JOptionPane.OK_OPTION) {
			String name = MainClass.getNameUser();
			
			if(name != "") {
				System.out.println(name);
				int nickDec = savePane.showConfirmDialog(savePane, "do you want to use a nickname?", "Nickname or name", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(nickDec == JOptionPane.OK_OPTION)
					nickname = savePane.showInputDialog(savePane, "Nickname:", "Insert nickname", JOptionPane.PLAIN_MESSAGE);
				else
					nickname = name;
			} else {
				nickname = savePane.showInputDialog(savePane, "Nickname:", "Insert nickname", JOptionPane.PLAIN_MESSAGE);
			}
			
			//checks if nickname/name is already taken 
			ArrayList<String[]> alreadyExisting = DataClass.searchSub(nickname);
			if(alreadyExisting.size() > 0) {
				//keeps on asking a new nickname until an available one is inserted 
				do {
				nickname = savePane.showInputDialog(savePane, "Already taken. Insert another one", "Insert nickname", JOptionPane.PLAIN_MESSAGE);
				alreadyExisting = DataClass.searchSub(nickname);} while(alreadyExisting.size() > 0);
			}
			
			DecimalFormat dformat = new DecimalFormat("0.#");
			DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
			sym.setDecimalSeparator('.');
			dformat.setDecimalFormatSymbols(sym);
			DataClass.writeData(nickname + ";" + dformat.format(resultsList[0]) + ";" + dformat.format(resultsList[1]) + ";" + dformat.format(resultsList[2]) + ";" + dformat.format(resultsList[3]) + ";" + dformat.format(resultsList[4]));
			saveButton.setEnabled(false);
		}
		
		} else if(e.getActionCommand() == "redo")
			TestClass.resetTest();
	}

}
