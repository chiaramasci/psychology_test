package robo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HistogramClass extends JPanel{
	private double[] valuesList;
	private String[] labelsList;
	private String type;
	private int numValues;
	
	private int GRAPH_HEIGHT = 380;
	private int GRAPH_WIDTH = 600;
	private int MAX_DIAM = 40;
	private int MIN_DIAM = 10;
	private int MAX_WIDTH = 600;
	private int MIN_WIDTH = 0;
	private int MAX_POS_CIRCLE = MAX_WIDTH - MAX_DIAM;
	private int MIN_POS_CIRCLE = MIN_WIDTH + 250;
	private int LINE_HEIGHT = MAX_DIAM + 10;
	
	private final Font font = CTheme.textFont;
	private final Color[] COLOR_CIRCLES = {CTheme.lowColor,CTheme.medColor,CTheme.highColor};
	private double maxValue = 0;
	private double minValue = 20;
	
	HistogramClass(double[] values, String[] labels, String typeh){
		setPreferredSize(new Dimension(GRAPH_WIDTH,GRAPH_HEIGHT));
		
		valuesList = values; 
		labelsList = labels; 
		numValues = values.length;
		type = typeh;
		
		for(int i = 0; i < numValues; i++) {
			if(valuesList[i] != 0) {
			if(valuesList[i] > maxValue)
				maxValue = valuesList[i];
			if(valuesList[i] < minValue)
				minValue = valuesList[i];
		}
		}
		
		this.setBackground(CTheme.wbackgroundColor);
	}
	
	public void updateDimensions(int numOfGraphs) {
		if(type == "summary") {
			//scale dimensions
			if(numOfGraphs == 1) {
				GRAPH_HEIGHT = 300;
				GRAPH_WIDTH = 600;
				MAX_DIAM = 40;
				MIN_DIAM = 10;
				MAX_WIDTH = 600;
				MIN_WIDTH = 0;
				MAX_POS_CIRCLE = MAX_WIDTH - MAX_DIAM;
				MIN_POS_CIRCLE = MIN_WIDTH + 250;
				LINE_HEIGHT = MAX_DIAM + 10;
			} else if(numOfGraphs == 2) {
				GRAPH_HEIGHT = 300;
				GRAPH_WIDTH = 600;
				MAX_DIAM = 40;
				MIN_DIAM = 10;
				MAX_WIDTH = 600;
				MIN_WIDTH = 0;
				MAX_POS_CIRCLE = MAX_WIDTH - MAX_DIAM;
				MIN_POS_CIRCLE = MIN_WIDTH + 250;
				LINE_HEIGHT = MAX_DIAM + 10;
				
			} else if(numOfGraphs == 3) {
				GRAPH_HEIGHT = 300 / 2;
				GRAPH_WIDTH = 600 / 2;
				MAX_DIAM = 20;
				MIN_DIAM = 10;
				MAX_WIDTH = 600 / 3;
				MIN_WIDTH = 0;
				MAX_POS_CIRCLE = MAX_WIDTH - MAX_DIAM;
				MIN_POS_CIRCLE = MIN_WIDTH + 150;
				LINE_HEIGHT = MAX_DIAM + 10;
				
			} else if(numOfGraphs == 4) {
				GRAPH_HEIGHT = 300 / 2;
				GRAPH_WIDTH = 600 / 2;
				MAX_DIAM = 20;
				MIN_DIAM = 10;
				MAX_WIDTH = 600 / 3;
				MIN_WIDTH = 0;
				MAX_POS_CIRCLE = MAX_WIDTH - MAX_DIAM;
				MIN_POS_CIRCLE = MIN_WIDTH + 150;
				LINE_HEIGHT = MAX_DIAM + 10;
				
			} else if(numOfGraphs == 5) {
				GRAPH_HEIGHT = 300 / 2;
				GRAPH_WIDTH = 600 / 3;
				MAX_DIAM = 20;
				MIN_DIAM = 10;
				MAX_WIDTH = 600 / 3;
				MIN_WIDTH = 0;
				MAX_POS_CIRCLE = MAX_WIDTH - MAX_DIAM;
				MIN_POS_CIRCLE = MIN_WIDTH + 150;
				LINE_HEIGHT = MAX_DIAM + 10;
			}
			
			
		}
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		//IF THERE ARE VALUES
		if(!(valuesList[0] == 0.00 && valuesList[1] == 0.00 && valuesList[2] == 0.00)) {
		
		//CREATION OF CIRCLES
		//for each value creates circle, lines, values...
		for(int i = 0; i < numValues; i++) {
			int diam = 0;
			Color color = COLOR_CIRCLES[0];
			int x = 0;
			int y = 0;
			
			if(valuesList[i] == maxValue) {
				diam = MAX_DIAM;
				x = MAX_POS_CIRCLE;
				}
			else if(valuesList[i] == minValue) {
				diam = MIN_DIAM;
				x = MIN_POS_CIRCLE;
			}
			else if(valuesList[i] == 0) {
				diam = 0;
				x = MIN_POS_CIRCLE - 90;
			}
			else {
				//proportion to find the diam in pixels
				diam = (int) ((MAX_DIAM * valuesList[i]) / maxValue);
				//proportion to find the x in pixels
				x = (int) ((MAX_POS_CIRCLE * valuesList[i]) / maxValue);
			}
				
			y = i * LINE_HEIGHT + ((LINE_HEIGHT - diam)/2);
			
			String lmh = DataClass.lmhData(valuesList[i]);
			
			if(type == "result") {
			if(lmh == "low") {
				color = COLOR_CIRCLES[0];}
			else if(lmh == "medium") { 
				color = COLOR_CIRCLES[1];}
			else if(lmh == "high") {
				color = COLOR_CIRCLES[2];}
			} else if(type == "summary") {
				color = COLOR_CIRCLES[2];
			}
			
			//LABELS CHARACTERISTICS
			Color colorLabel = COLOR_CIRCLES[2];
			page.setColor(colorLabel);
			page.setFont(font);
			page.drawString(labelsList[i], 0, i* LINE_HEIGHT + (LINE_HEIGHT/2));
			
			//LABEL VALUES
			page.drawString(Double.toString(valuesList[i]), x + diam/2 - 5, LINE_HEIGHT * numValues + 30);
			
			//LINES
			//creates a horizontal line for every row
			Color colorLine = color;
			
			//vertical lines
			page.drawLine(MIN_POS_CIRCLE - 90, 0, MIN_POS_CIRCLE - 90, LINE_HEIGHT * numValues); //y axes
			page.setColor(colorLine);
			page.drawLine(x + diam/2, 0, x + diam/2, LINE_HEIGHT * numValues + 20);
//			page.drawLine(MIN_WIDTH, LINE_HEIGHT * numValues, MAX_WIDTH, LINE_HEIGHT * numValues);
			
			//horizontal
			page.setColor(CTheme.textColor);
			page.drawLine(MIN_POS_CIRCLE - 90, LINE_HEIGHT * numValues, MAX_WIDTH, LINE_HEIGHT * numValues); //x axes
			
			//draw circles on lines
			page.setColor(color);
			page.fillOval(x, y, diam, diam);
			
		}
		
		//LEGEND (if it is test result)
		if(type == "result") {
			page.setColor(Color.WHITE);
			page.fillRect(MAX_WIDTH - 500, numValues * LINE_HEIGHT + 80, MAX_WIDTH - 180, 40);
			
			page.setColor(CTheme.lowColor);
			page.fillRect(MAX_WIDTH - 450, numValues * LINE_HEIGHT + 90, 20, 20);
			page.setColor(CTheme.medColor);
			page.fillRect(MAX_WIDTH - 300, numValues * LINE_HEIGHT + 90, 20, 20);
			page.setColor(CTheme.highColor);
			page.fillRect(MAX_WIDTH - 150, numValues * LINE_HEIGHT + 90, 20, 20);
			
			page.setFont(font);
			page.drawString("LOW", MAX_WIDTH - 420, numValues * LINE_HEIGHT + 105);
			page.drawString("MEDIUM", MAX_WIDTH - 270, numValues * LINE_HEIGHT + 105);
			page.drawString("HIGH",  MAX_WIDTH - 120, numValues * LINE_HEIGHT + 105);
		}
		
	} else if (valuesList[0] == 0.00 && valuesList[1] == 0.00 && valuesList[2] == 0.00) {
		int width = this.getWidth();
		int height = this.getHeight();
		String nodata = "No data available";
		
		page.setColor(CTheme.medColor);
		page.setFont(font);
		page.drawString(nodata, 0, 0);
	}
	}
}
