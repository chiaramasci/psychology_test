package robo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*CLASS OF THE TAB 'SEARCH
 * 
 * */

public class SearchClass extends JPanel implements DocumentListener{
	private JTextField searchInput;
	private JPanel searchPanel;
	private static JPanel resultsPanel;
	
	public SearchClass() {
		searchPanel = new JPanel();
		searchInput = new JTextField();
		searchInput.getDocument().addDocumentListener(this);
		searchPanel.setPreferredSize(new Dimension(this.getWidth(),40));
		searchPanel.setBackground(CTheme.lbackgroundColor);
		searchPanel.setLayout(new BorderLayout());
		searchPanel.add(searchInput,BorderLayout.CENTER);

	    resultsPanel = new JPanel();
	    resultsPanel.setBackground(CTheme.wbackgroundColor);
		
		this.setLayout(new BorderLayout());
		this.add(searchPanel,BorderLayout.NORTH);
		this.add(resultsPanel);
		search("");
	}
	
	private static void search(String substring) {
		ArrayList<String[]> results = DataClass.searchSub(substring);
		resultsPanel.removeAll();
		resultsPanel.revalidate();
		resultsPanel.repaint();
		
		for(int i = 0; i < results.size(); i++) {
			SearchResult searchResult = new SearchResult(results.get(i));
			resultsPanel.add(searchResult);
			resultsPanel.repaint();
		}
	}
	
	//update after a new result is saved from DataClass
	public static void updateSearch() {
		search("");
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		String searchString = searchInput.getText();	
		search(searchString);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		String searchString = searchInput.getText();	
		search(searchString);
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		String searchString = searchInput.getText();	
		search(searchString);
		
	}
}
