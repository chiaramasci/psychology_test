package robo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*CLASS THAT MANAGES, WRITES, READS DATA AND CALCULATES MEAN, SD
 * 
 * */

public class DataClass {
	private static final String PATH = "src/robo/user-data.csv";
	private static ArrayList<String[]> data; //String[] as the nickname is a string
	
	//read
	public static ArrayList<String[]> readData() {
		data = new ArrayList<String[]>();
		
		try {
			Scanner read = new Scanner(new File(PATH));
			
			do {
				
				try {
				String line = read.nextLine();
				String[] lineL = line.split(";");
				data.add(lineL);
				} catch(NoSuchElementException no) {
					System.out.println("oh no");
				}
			}while(read.hasNextLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	//write
	public static void writeData(String dataToWrite) {
		ArrayList<String> storedText = new ArrayList<String>();
		
		try {
			Scanner read = new Scanner(new File(PATH));
			
			do {
				
				try {
				String line = read.nextLine();
				storedText.add(line);
				
				} catch(NoSuchElementException no) {
					System.out.println("oh no");
				}
				
			}while(read.hasNextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		storedText.add(dataToWrite);
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(PATH));
			
			for (int i = 0; i < storedText.size(); i++) {
				pw.write(storedText.get(i) + "\n");
			}
			
			pw.close();
			update();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
	 
		
		
		
	}
	
	//updates searchTab and summaryTab
	private static void update() {
		SummaryClass.updateSummary();
		SearchClass.updateSearch();
	}
	
	//erase
	public static void resetData() {
		try {
			Writer output;
			output = new BufferedWriter(new FileWriter(PATH)); 
			output.close();
			update();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//search substring
	public static ArrayList<String[]> searchSub(String sub) {
		ArrayList<String[]> occurrencies = new ArrayList<String[]>();
		
		try {
			Scanner read = new Scanner(new File(PATH));
			
			do {
				try {
				String line = read.nextLine();
				if(line.contains(sub)){
					String[] lineL = line.split(";");
					occurrencies.add(lineL);
				}
				}catch(NoSuchElementException no) {
					System.out.println("oh no");
				}
			}while(read.hasNextLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return occurrencies;
	}
	
	//mean 5 characteristics
	public static double[] mean5Char() {
		readData(); //reads and updates changes
		
		double[] means;
		double total1 = 0.0;
		double total2 = 0.0;
		double total3 = 0.0;
		double total4 = 0.0;
		double total5 = 0.0;
		
		int numUs = data.size();
		
		if(numUs > 0) {
			//gets total of each characteristic
			for(int per = 0; per < numUs; per++) {
				total1 += Double.parseDouble(data.get(per)[1]); //we start from 1 as 0 is the nickname
				total2 += Double.parseDouble(data.get(per)[2]);
				total3 += Double.parseDouble(data.get(per)[3]);
				total4 += Double.parseDouble(data.get(per)[4]);
				total5 += Double.parseDouble(data.get(per)[5]);
			}
			
			//gets mean of each characteristic
				double mean1 = total1/numUs;
				double mean2 = total2/numUs;
				double mean3 = total3/numUs;
				double mean4 = total4/numUs;
				double mean5 = total5/numUs;
				
			System.out.println("MEANS: " + mean1 + " " + mean2 + " " + mean3 + " " + mean4 + " " + mean5);
				
			double[] temp = {mean1,mean2,mean3,mean4,mean5};
			means = temp;
		} else {
			double[] temp = {0.0,0.0,0.0,0.0,0.0};
			means = temp;
		}
		
		return means;
		
	}
	
	//standard deviation of data TO CHECK BECAUSE IT IS FUCKING WRONG
	public static double[] sd5Char() {
		readData(); //reads and updates changes
		
		double[] sds = {0.0,0.0,0.0,0.0,0.0};
		
		//get mean5char
		double[] means = mean5Char();
		//get number of users
		int numUs = data.size();
		
		if(numUs != 0) {
		//for each characteristic
			for(int ch = 0; ch < 5; ch++) { 
				int sumDif = 0;
					//sum the differences between the mean of the characteristic and the values stored
				    //data.get(per)[ch + 1]) as data.get(per)[0] is the nickname
					for(int per = 0; per < numUs; per++)
						sumDif += Math.pow(Double.parseDouble(data.get(per)[ch + 1]) - means[ch],2);
				//divide sum by number of users - 1
				//square root
				//store it 
				sds[ch] = Math.sqrt((double) sumDif/numUs);	
			}
		}
		
		System.out.println("SDS: " + sds[0] + " " + sds[1] + " " + sds[2] + " " + sds[3] + " " + sds[4]);
		
		return sds;}
	
	//are values low,medium or high? (list of values)
	public static String[] lmhData5(double[] values) {
		String[] lmh = {"unknown","unknown","unknown","unknown","unknown"};
		
		for(int i = 0; i < values.length; i++) {
			if(values[i] < 3.0) 
				lmh[i] = "low";
			else if(values[i] > 5.0)
				lmh[i] = "high";
			else
				lmh[i] = "medium";
			
		}
		
		System.out.println("LMH: " + lmh[0] + " " + lmh[1] + " " + lmh[2] + " " + lmh[3] + " " + lmh[4]);
		
		return lmh;
	}
	
	//are values low,medium or high?
		public static String lmhData(double value) {
			String lmh = "unknown";
			
			
				if(value < 3.0) 
					lmh = "low";
				else if(value > 5.0)
					lmh = "high";
				else
					lmh = "medium";
				
			
			return lmh;
		}
		
	//count how many numbers are low,medium,high
		public static double[] lmhDataCount(int charNum) {
			readData();
			int numUs = data.size();
			
			int countl = 0;
			int countm = 0;
			int counth = 0;
			
			for(int i = 0; i< numUs ; i++) {
				String lmh = lmhData(Double.parseDouble(data.get(i)[charNum + 1]));
				
				if(lmh == "low") 
					countl += 1;
				else if(lmh == "high")
					counth += 1;
				else if(lmh == "medium")
					countm += 1;
			}
			
			double[] lmhCount = {countl,countm,counth};
			
			return lmhCount;
		}
}
