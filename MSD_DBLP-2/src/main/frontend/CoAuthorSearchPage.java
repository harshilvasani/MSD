/*package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import queryengine.app.App;
import queryengine.query.utils.AuthorName;
import resources.personrecord.Author;
import resources.personrecord.IPerson;
import validator.utils.Validator;

public class CoAuthorSearchPage {

	JFrame frame;
	JButton btnLogout;
	JButton btnProfile;
	JButton btnFavorites;
	JButton btnAuthorSearch;
	JButton btnCoAuthorSearch;
	JButton btnSimilarAuthorSearch;
	JLabel lblCoAuthorSearch;
	JFormattedTextField ftfAuthorName;
	JLabel lblDisplayingResults;
	JLabel lblAuthorName;
	JButton btnSearch;
	JScrollPane scroller;
	JButton btnaddFavoriteAuthor;
	JFormattedTextField ftfAuthorNameContains;
	JFormattedTextField ftfMinimumPublication;
	JButton btnFilter;
	Boolean scrollerFlag;
	Boolean authorNameContainsFlag;
	Boolean minimumPublicationFlag;
	Boolean displayingResultsFlag;

	public CoAuthorSearchPage() {
		initialize();
	}

	*//**
	 * Initialize the contents of the frame.
	 *//*
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 0, 1350, 725);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scroller = new JScrollPane();
		scrollerFlag = true;
		authorNameContainsFlag = false;
		minimumPublicationFlag = false;
		displayingResultsFlag = false;
		btnaddFavoriteAuthor = new JButton("");
		ftfAuthorNameContains = new JFormattedTextField();
		ftfMinimumPublication = new JFormattedTextField();
		btnFilter = new JButton("");

		btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Page lp = new Login_Page();
				lp.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().setLayout(null);
		btnLogout.setForeground(new Color(0, 255, 0));
		btnLogout.setBounds(1075, 10, 200, 25);
		frame.getContentPane().add(btnLogout);

		btnProfile = new JButton("Profile");
		btnProfile.setBackground(new Color(255, 255, 255));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile_Page pp = new Profile_Page();
				pp.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnProfile.setForeground(new Color(0, 255, 0));
		btnProfile.setBounds(875, 10, 200, 25);
		frame.getContentPane().add(btnProfile);

		btnFavorites = new JButton("Favorites List");
		btnFavorites.setBackground(new Color(255, 255, 255));
		btnFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFavorites.setForeground(new Color(0, 255, 0));
		btnFavorites.setBounds(675, 10, 200, 25);
		frame.getContentPane().add(btnFavorites);

		btnAuthorSearch = new JButton("Author Search");
		btnAuthorSearch.setBackground(new Color(255, 255, 255));
		btnAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAuthorSearch.setForeground(new Color(0, 255, 0));
		btnAuthorSearch.setBounds(475, 10, 200, 25);
		frame.getContentPane().add(btnAuthorSearch);

		btnCoAuthorSearch = new JButton("Co-Author Search");
		btnCoAuthorSearch.setBackground(new Color(255, 255, 255));
		btnCoAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCoAuthorSearch.setForeground(new Color(0, 255, 0));
		btnCoAuthorSearch.setBounds(275, 10, 200, 25);
		frame.getContentPane().add(btnCoAuthorSearch);

		btnSimilarAuthorSearch = new JButton("Similar Author Search");
		btnSimilarAuthorSearch.setBackground(new Color(255, 255, 255));
		btnSimilarAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSimilarAuthorSearch.setForeground(new Color(0, 255, 0));
		btnSimilarAuthorSearch.setBounds(75, 10, 200, 25);
		frame.getContentPane().add(btnSimilarAuthorSearch);
		
		lblCoAuthorSearch = new JLabel("Co Author Search");
		lblCoAuthorSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoAuthorSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCoAuthorSearch.setForeground(new Color(0, 255, 0));
		lblCoAuthorSearch.setBounds(150, 60, 200, 28);
		frame.getContentPane().add(lblCoAuthorSearch);

		ftfAuthorName = new JFormattedTextField();
		ftfAuthorName.setForeground(new Color(0, 255, 0));
		ftfAuthorName.setText("");
		ftfAuthorName.setBounds(150, 120, 200, 20);
		frame.getContentPane().add(ftfAuthorName);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String authorName = ftfAuthorName.getText();

				InterfacingForCoAuthorSearch coAuthorSearchComm = new InterfacingForCoAuthorSearch(authorName);
				
			//	List<IPerson> result = coAuthorSearchComm.sendCoAuthorCriteriaToApp();

				List<IPerson> result = new ArrayList<IPerson>();
				for(int i=1;i<=50;i++){
					result.add(new Author("abc", i, "abc", "abc", "6", "article"));
					result.add(new Author("abc", i, "abc", "abc", "7", "article"));
				} 
				
				displaySearchResults(result,coAuthorSearchComm);
			}
		});
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(192, 151, 110, 25);
		frame.getContentPane().add(btnSearch);

		lblAuthorName = new JLabel("Author Name:");
		lblAuthorName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAuthorName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAuthorName.setBounds(24, 123, 116, 14);
		frame.getContentPane().add(lblAuthorName);

	}
	
	public void displaySearchResults(List<IPerson> result, InterfacingForCoAuthorSearch coAuthorSearchComm){
		if(scrollerFlag){
			frame.getContentPane().remove(scroller);
			frame.getContentPane().remove(btnaddFavoriteAuthor);
			frame.getContentPane().remove(ftfAuthorNameContains);
			frame.getContentPane().remove(ftfMinimumPublication);
			frame.getContentPane().remove(btnFilter);
			scrollerFlag = false;
		}
		
		if(authorNameContainsFlag == false){
			JLabel lblAuthorNameContains = new JLabel("Author Name Contains:");
			lblAuthorNameContains.setBounds(192, 300, 150, 25);
			frame.getContentPane().add(lblAuthorNameContains);
			authorNameContainsFlag = true;
		}

		ftfAuthorNameContains = new JFormattedTextField();
		ftfAuthorNameContains.setForeground(new Color(0, 255, 0));
		ftfAuthorNameContains.setText("");
		ftfAuthorNameContains.setBounds(352, 300, 200, 25);
		frame.getContentPane().add(ftfAuthorNameContains);

		if(minimumPublicationFlag == false){
			JLabel lblMinimumPublication = new JLabel("Minimum Publication:");
			lblMinimumPublication.setBounds(572, 300, 150, 25);
			frame.getContentPane().add(lblMinimumPublication);
			minimumPublicationFlag = true;
		}
			
		ftfMinimumPublication = new JFormattedTextField();
		ftfMinimumPublication.setForeground(new Color(0, 255, 0));
		ftfMinimumPublication.setText("");
		ftfMinimumPublication.setBounds(732, 300, 200, 25);
		frame.getContentPane().add(ftfMinimumPublication);
		
		if(displayingResultsFlag == false){
			lblDisplayingResults = new JLabel("Displaying Results");
			lblDisplayingResults.setBounds(150, 345, 200, 14);
			frame.getContentPane().add(lblDisplayingResults);
			displayingResultsFlag = true;
		}
		
		JPanel authorDisplayArea = new JPanel();
		authorDisplayArea.setLayout(new BoxLayout(authorDisplayArea, BoxLayout.Y_AXIS));

		scroller = new JScrollPane(authorDisplayArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setBounds(150, 370, 1000, 300);
		frame.getContentPane().add(scroller);
		scrollerFlag = true;
		
		btnFilter = new JButton("Apply Filters");
		btnFilter.setBackground(new Color(255, 255, 255));
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				coAuthorSearchComm.setFilters(ftfAuthorNameContains.getText(),
						ftfMinimumPublication.getText());

			//	List<IPerson> filterSet = coAuthorSearchComm.sendFiltersToApp();
				List<IPerson> filterSet = new ArrayList<IPerson>();
				for(int i=1;i<=50;i++){
					filterSet.add(new Author("abc", i, "abc", "abc", "8", "article"));
					filterSet.add(new Author("abc", i, "abc", "abc", "9", "article"));
				} 
				
				displaySearchResults(filterSet,coAuthorSearchComm);

			}
		});
		btnFilter.setForeground(new Color(0, 255, 0));
		btnFilter.setBounds(952, 300, 200, 25);
		frame.getContentPane().add(btnFilter);

		DefaultTableModel model = new DefaultTableModel(){

		    @Override
		    public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }

		   };
		   
		JTable searchResults = new JTable(model);
		authorDisplayArea.add(searchResults);  

		btnaddFavoriteAuthor = new JButton("Add to Favorites");
		btnaddFavoriteAuthor.setBackground(new Color(255, 255, 255));
		btnaddFavoriteAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = searchResults.getSelectedRow();
				if(row>0){
					System.out.println(row+" "+searchResults.getValueAt(row,0)+" "+
							searchResults.getValueAt(row,1)+" "+searchResults.getValueAt(row,2)+" "+
							searchResults.getValueAt(row,3)+" "+searchResults.getValueAt(row,4)
							);
					System.out.println(result.get(row-1));
				}
			}
		});
		btnaddFavoriteAuthor.setForeground(new Color(0, 255, 0));
		btnaddFavoriteAuthor.setBounds(550, 345, 200, 15);
		frame.getContentPane().add(btnaddFavoriteAuthor);

		model.addColumn("Person Name"); 
		model.addColumn("Publication Title");
		model.addColumn("Publication Type");
		model.addColumn("Publication Year");
		model.addColumn("Journal/Publication/Conference");

		model.addRow(new Object[]{"Person Name","Publication Title",
				"Publication Type", "Publication Year", "Journal/Publication/Conference"});

		if(result != null && result.size() > 0){
			for( int i = 0; i < result.size() ; i++ ){

				IPerson person = result.get(i);

				if( person instanceof Author ){

					Author a = (Author) person;

					model.addRow(new Object[]{a.getPersonName(),a.getPublicationTitle(),
							a.getPublicationType(), a.getPublicationYear(), a.getJournalName()});
					

				}
			}
		}

		frame.repaint();

	}
}
*/