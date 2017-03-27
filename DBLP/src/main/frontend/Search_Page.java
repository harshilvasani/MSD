package frontend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import resources.person.Author;
import resources.person.IPerson;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class Search_Page {

	JFrame frame;
	JButton btnLogout;
	JButton btnProfile;
	JButton btnFavorites;
	JButton btnAuthorSearch;
	JButton btnCoAuthorSearch;
	JButton btnSimilarAuthorSearch;
	JLabel lblAuthorSearch;
	JFormattedTextField ftfPublicationTitle;
	JFormattedTextField ftfJournalName;
	JFormattedTextField ftfMinimumYear;
	JFormattedTextField ftfAbsence;
	JLabel lblDisplayingResults;
	JLabel lblPublicationTitle;
	JLabel lblJournalName;
	JLabel lblMinimumYear;
	JLabel lblAbsenceFromCommittee;
	JButton btnSearch;
	JScrollPane scroller;
	Boolean scrollerFlag;
	Boolean authorNameContainsFlag;
	Boolean minimumPublicationFlag;
	Boolean displayingResultsFlag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Page window = new Search_Page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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

		lblAuthorSearch = new JLabel("Author Search");
		lblAuthorSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthorSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAuthorSearch.setForeground(new Color(0, 255, 0));
		lblAuthorSearch.setBounds(150, 60, 200, 28);
		frame.getContentPane().add(lblAuthorSearch);

		ftfPublicationTitle = new JFormattedTextField();
		ftfPublicationTitle.setForeground(new Color(0, 255, 0));
		ftfPublicationTitle.setText("");
		ftfPublicationTitle.setBounds(150, 120, 200, 20);
		frame.getContentPane().add(ftfPublicationTitle);

		ftfJournalName = new JFormattedTextField();
		ftfJournalName.setText("");
		ftfJournalName.setForeground(Color.GREEN);
		ftfJournalName.setBounds(150, 151, 200, 20);
		frame.getContentPane().add(ftfJournalName);

		ftfMinimumYear = new JFormattedTextField();
		ftfMinimumYear.setText("");
		ftfMinimumYear.setForeground(Color.GREEN);
		ftfMinimumYear.setBounds(150, 182, 200, 20);
		frame.getContentPane().add(ftfMinimumYear);

		ftfAbsence = new JFormattedTextField();
		ftfAbsence.setText("");
		ftfAbsence.setForeground(Color.GREEN);
		ftfAbsence.setBounds(150, 213, 200, 20);
		frame.getContentPane().add(ftfAbsence);


		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String publicationTitle = ftfPublicationTitle.getText();
				String journalName = ftfJournalName.getText();
				String minYear = ftfMinimumYear.getText();
				String absence = ftfAbsence.getText();

				Interfacing_for_Author_Search authorSearchComm = new Interfacing_for_Author_Search(
						publicationTitle, journalName, minYear, absence);

			//	List<IPerson> result = authorSearchComm.sendSearchCriteriaToApp();

				List<IPerson> result = new ArrayList<IPerson>();
				for(int i=1;i<=50;i++){
					result.add(new Author("abc", i, "abc", "abc", "6", "article"));
					result.add(new Author("abc", i, "abc", "abc", "7", "article"));
				} 
				
				displaySearchResults(result,authorSearchComm);
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(192, 244, 110, 25);
		frame.getContentPane().add(btnSearch);

		lblPublicationTitle = new JLabel("Publication Title");
		lblPublicationTitle.setBounds(24, 123, 116, 14);
		frame.getContentPane().add(lblPublicationTitle);

		lblJournalName = new JLabel("Journal Name");
		lblJournalName.setBounds(24, 154, 116, 14);
		frame.getContentPane().add(lblJournalName);

		lblMinimumYear = new JLabel("Minimum Year");
		lblMinimumYear.setBounds(24, 185, 116, 14);
		frame.getContentPane().add(lblMinimumYear);

		lblAbsenceFromCommittee = new JLabel("Absence from Committee");
		lblAbsenceFromCommittee.setBounds(24, 216, 116, 14);
		frame.getContentPane().add(lblAbsenceFromCommittee);


	}

	public void displaySearchResults(List<IPerson> result, Interfacing_for_Author_Search authorSearchComm){
		if(scrollerFlag){
			frame.getContentPane().remove(scroller);
			scrollerFlag = false;
		}
		
		if(authorNameContainsFlag == false){
			JLabel lblAuthorNameContains = new JLabel("Author Name Contains:");
			lblAuthorNameContains.setBounds(192, 300, 150, 25);
			frame.getContentPane().add(lblAuthorNameContains);
			authorNameContainsFlag = true;
		}

		JFormattedTextField ftfAuthorNameContains = new JFormattedTextField();
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
			
		JFormattedTextField ftfMinimumPublication = new JFormattedTextField();
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
		
		JButton btnFilter = new JButton("Apply Filters");
		btnFilter.setBackground(new Color(255, 255, 255));
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				authorSearchComm.setFilters(ftfAuthorNameContains.getText(),
						ftfMinimumPublication.getText());

			//	List<IPerson> filterSet = authorSearchComm.sendFiltersToApp();
				List<IPerson> filterSet = new ArrayList<IPerson>();
				for(int i=1;i<=50;i++){
					filterSet.add(new Author("abc", i, "abc", "abc", "8", "article"));
					filterSet.add(new Author("abc", i, "abc", "abc", "9", "article"));
				} 
				
				displaySearchResults(filterSet,authorSearchComm);

			}
		});
		btnFilter.setForeground(new Color(0, 255, 0));
		btnFilter.setBounds(952, 300, 200, 25);
		frame.getContentPane().add(btnFilter);

		DefaultTableModel model = new DefaultTableModel();
		JTable searchResults = new JTable(model);
		authorDisplayArea.add(searchResults);  

		JButton btnaddFavoriteAuthor = new JButton("Add to Favorites");
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
