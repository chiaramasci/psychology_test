package robo;

import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class SummarySingle extends JPanel{
	private final String[] LABELS = {"low","medium","high"};
	private HistogramClass histogram;
	private DecimalFormat dfor;
	
	public SummarySingle(String title,int charNum) {
		dfor = new DecimalFormat("0.##");
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		JLabel titleLab = new JLabel(title.toUpperCase(), SwingConstants.CENTER);
		titleLab.setAlignmentX(CENTER_ALIGNMENT);
		titleLab.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		
		//makes histogram
		double[] values = DataClass.lmhDataCount(charNum);
		histogram = new HistogramClass(values,LABELS,"summary");
		
		//mean and standard deviation of the given characteristic
		double[] means = DataClass.mean5Char();
		double[] sds = DataClass.sd5Char();
		double mean = means[charNum];
		double sd = sds[charNum];
		
		JLabel meanLab = new JLabel("Mean: " + dfor.format(mean));
		meanLab.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel sdLab = new JLabel("Sd: " + dfor.format(sd));
		sdLab.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(titleLab);
		this.add(histogram);
		this.add(meanLab);
		this.add(sdLab);
		
		this.setBackground(CTheme.wbackgroundColor);
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	}
	
	public void changeLayout(int numOfGraphs) {
		histogram.updateDimensions(numOfGraphs);
	}
}
