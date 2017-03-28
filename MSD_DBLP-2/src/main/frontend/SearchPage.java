package frontend;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import frontend.utils.FavoriteAuthorUtils;
import frontend.utils.FilterUtils;
import frontend.utils.SearchUtils;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.Author;
import resources.personrecord.IPerson;

import javax.swing.JFormattedTextField;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

public class SearchPage {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private JButton btnLogout;
	private JButton btnProfile;
	private JButton btnFavorites;
	private JButton btnAuthorSearch;
	private JButton btnCoAuthorSearch;
	private JButton btnSimilarAuthorSearch;
	private JButton btnaddFavoriteAuthor;
	private JButton btnSearch;
	private JButton btnFilter;
	private JLabel lblAuthorSearch;
	private JFormattedTextField ftfPublicationTitle;
	private JFormattedTextField ftfJournalName;
	private JFormattedTextField ftfMinimumYear;
	private JFormattedTextField ftfAbsence;
	private JFormattedTextField ftfAuthorNameContains;
	private JFormattedTextField ftfMinimumPublication;
	private JLabel lblDisplayingResults;
	private JLabel lblPublicationTitle;
	private JLabel lblJournalName;
	private JLabel lblMinimumYear;
	private JLabel lblAbsenceFromCommittee;
	private JScrollPane scroller;
	private Boolean scrollerFlag;
	private Boolean authorNameContainsFlag;
	private Boolean minimumPublicationFlag;
	private Boolean displayingResultsFlag;
	private JTable searchResultTable;
	private List<IPerson> searchResult;
	private List<IPerson> filterResult;
 	
	public SearchPage() {
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
		btnaddFavoriteAuthor = new JButton("");
		ftfAuthorNameContains = new JFormattedTextField();
		ftfMinimumPublication = new JFormattedTextField();
		btnFilter = new JButton("");

		btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();

				JFrame loginPageFrame = lp.getFrame();

				if(loginPageFrame != null){
					loginPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
				/*else
					lblError.setText("Error in creating Login Page");*/
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
				ProfilePage pp = new ProfilePage();
				JFrame profilePageFrame = pp.getFrame();

				if(profilePageFrame != null){
					profilePageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
				/*else
					lblError.setText("Error in creating Profile Page");*/
			}
		});
		btnProfile.setForeground(new Color(0, 255, 0));
		btnProfile.setBounds(875, 10, 200, 25);
		frame.getContentPane().add(btnProfile);

		btnFavorites = new JButton("Favorites List");
		btnFavorites.setBackground(new Color(255, 255, 255));
		btnFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavoriteAuthorPage fap = new FavoriteAuthorPage();
				JFrame favoriteAuthorPageFrame = fap.getFrame();

				if(favoriteAuthorPageFrame != null){
					favoriteAuthorPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
			}
		});
		btnFavorites.setForeground(new Color(0, 255, 0));
		btnFavorites.setBounds(675, 10, 200, 25);
		frame.getContentPane().add(btnFavorites);

		btnAuthorSearch = new JButton("Author Search");
		btnAuthorSearch.setBackground(new Color(255, 255, 255));
		
		btnAuthorSearch.setForeground(new Color(0, 255, 0));
		btnAuthorSearch.setBounds(475, 10, 200, 25);
		frame.getContentPane().add(btnAuthorSearch);

		btnCoAuthorSearch = new JButton("Co-Author Search");
		btnCoAuthorSearch.setBackground(new Color(255, 255, 255));
		btnCoAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoAuthorSearchPage casp = new CoAuthorSearchPage();
				JFrame coAuthorSearchPageFrame = casp.getFrame();

				if(coAuthorSearchPageFrame != null){
					coAuthorSearchPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
			}
		});
		btnCoAuthorSearch.setForeground(new Color(0, 255, 0));
		btnCoAuthorSearch.setBounds(275, 10, 200, 25);
		frame.getContentPane().add(btnCoAuthorSearch);

		btnSimilarAuthorSearch = new JButton("Similar Author Search");
		btnSimilarAuthorSearch.setBackground(new Color(255, 255, 255));
		btnSimilarAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimilarAuthorSearchPage sasp = new SimilarAuthorSearchPage();
				JFrame similarAuthorSearchPageFrame = sasp.getFrame();

				if(similarAuthorSearchPageFrame != null){
					similarAuthorSearchPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
				
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
				String absenceYears = ftfAbsence.getText();

				searchResult = SearchUtils.getSearchResult(publicationTitle, minYear, journalName, absenceYears);
				filterResult = null;

				displayAndFilterSearchResults();
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

	private void displayAndFilterSearchResults(){
		if (scrollerFlag){
			frame.getContentPane().remove(scroller);
			frame.getContentPane().remove(btnaddFavoriteAuthor);
			frame.getContentPane().remove(ftfAuthorNameContains);
			frame.getContentPane().remove(ftfMinimumPublication);
			frame.getContentPane().remove(btnFilter);
			scrollerFlag = false;
		}
		
		if (!authorNameContainsFlag){
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

		if (!minimumPublicationFlag){
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
		
		if (!displayingResultsFlag){
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

				filterResult = FilterUtils.getFilteredResult(ftfAuthorNameContains.getText(), ftfMinimumPublication.getText(), searchResult);

				displayAndFilterSearchResults();
			}
		});
		btnFilter.setForeground(new Color(0, 255, 0));
		btnFilter.setBounds(952, 300, 200, 25);
		frame.getContentPane().add(btnFilter);

		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		   };
		   
		searchResultTable = new JTable(model);
		searchResultTable.setRowSelectionAllowed(false);
		authorDisplayArea.add(searchResultTable);  

		JButton btnaddFavoriteAuthor = new JButton("Add to Favorites");
		btnaddFavoriteAuthor.setBackground(new Color(255, 255, 255));
		btnaddFavoriteAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = searchResultTable.getSelectedRow();

				if(row == 1){
					String authorName = (String) searchResultTable.getValueAt(row,0);
					
					ResponseMessage rm = FavoriteAuthorUtils.addAuthorToFavouriteList(authorName);
					if(!rm.isSuccess())
						JOptionPane.showMessageDialog(getFrame(), rm.getMessage());
					else
						JOptionPane.showMessageDialog(getFrame(), authorName + " added!!");
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

		List<IPerson> displayResult = (filterResult == null) ? searchResult : filterResult;
		
		if(displayResult != null && displayResult.size() > 0){
			for( int i = 0; i < displayResult.size() ; i++ ){

				IPerson person = displayResult.get(i);

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