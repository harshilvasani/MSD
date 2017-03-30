package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import frontend.utils.CoAuthorSearchUtils;
import frontend.utils.FavoriteAuthorUtils;
import frontend.utils.FilterUtils;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.Author;
import resources.personrecord.IPerson;
import javax.swing.border.LineBorder;

public class CoAuthorSearchPage {

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
	private JLabel lblCoAuthorSearch;
	private JFormattedTextField ftfAuthorName;
	private JLabel lblDisplayingResults;
	private JLabel lblAuthorName;
	private JButton btnSearch;
	private JScrollPane scroller;
	private JButton btnaddFavoriteAuthor;
	private JFormattedTextField ftfAuthorNameContains;
	private JFormattedTextField ftfMinimumPublication;
	private JButton btnFilter;
	private Boolean scrollerFlag;
	private Boolean authorNameContainsFlag;
	private Boolean minimumPublicationFlag;
	private Boolean displayingResultsFlag;
	private JTable searchResultTable;
	private List<IPerson> searchResult;
	private List<IPerson> filterResult;

	public CoAuthorSearchPage() {
		initialize();
	}

	//**
	// Initialize the contents of the frame.
	//*
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.setBounds(0, 0, 1350, 725);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scroller = new JScrollPane();
		scrollerFlag = true;
		authorNameContainsFlag = false;
		minimumPublicationFlag = false;
		displayingResultsFlag = false;
		btnaddFavoriteAuthor = new JButton("");
		ftfAuthorNameContains = new JFormattedTextField();
		ftfMinimumPublication = new JFormattedTextField();
		btnFilter = new JButton("");

		btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();

				JFrame loginPageFrame = lp.getFrame();

				if(loginPageFrame != null){
					loginPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		btnLogout.setForeground(new Color(0, 0, 102));
		btnLogout.setBounds(1075, 10, 200, 25);
		frame.getContentPane().add(btnLogout);

		btnProfile = new JButton("PROFILE");
		btnProfile.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnProfile.setBackground(new Color(255, 255, 255));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilePage pp = new ProfilePage();

				JFrame profilePageFrame = pp.getFrame();

				if(profilePageFrame != null){
					profilePageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
			}
		});
		btnProfile.setForeground(new Color(0, 0, 102));
		btnProfile.setBounds(875, 10, 200, 25);
		frame.getContentPane().add(btnProfile);

		btnFavorites = new JButton("FAVORITES LIST");
		btnFavorites.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
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
		btnFavorites.setForeground(new Color(0, 0, 102));
		btnFavorites.setBounds(675, 10, 200, 25);
		frame.getContentPane().add(btnFavorites);

		btnAuthorSearch = new JButton("AUTHOR SEARCH");
		btnAuthorSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnAuthorSearch.setBackground(new Color(255, 255, 255));
		btnAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPage sp = new SearchPage();
				JFrame searchPageFrame = sp.getFrame();

				if(searchPageFrame != null){
					searchPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
			}
		});
		btnAuthorSearch.setForeground(new Color(0, 0, 102));
		btnAuthorSearch.setBounds(75, 10, 200, 25);
		frame.getContentPane().add(btnAuthorSearch);

		btnCoAuthorSearch = new JButton("CO AUTHOR SEARCH");
		btnCoAuthorSearch.setBorder(new LineBorder(new Color(0, 0, 102)));
		btnCoAuthorSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnCoAuthorSearch.setBackground(new Color(0, 0, 102));
		
		btnCoAuthorSearch.setForeground(new Color(0, 0, 102));
		btnCoAuthorSearch.setBounds(275, 10, 200, 25);
		frame.getContentPane().add(btnCoAuthorSearch);

		btnSimilarAuthorSearch = new JButton("SIMILAR AUTHOR SEARCH");
		btnSimilarAuthorSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
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
		btnSimilarAuthorSearch.setForeground(new Color(0, 0, 102));
		btnSimilarAuthorSearch.setBounds(475, 10, 200, 25);
		frame.getContentPane().add(btnSimilarAuthorSearch);

		lblCoAuthorSearch = new JLabel("CO AUTHOR SEARCH");
		lblCoAuthorSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoAuthorSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 24));
		lblCoAuthorSearch.setForeground(new Color(0, 0, 102));
		lblCoAuthorSearch.setBounds(551, 60, 242, 28);
		frame.getContentPane().add(lblCoAuthorSearch);

		ftfAuthorName = new JFormattedTextField();
		ftfAuthorName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		ftfAuthorName.setForeground(new Color(0, 0, 102));
		ftfAuthorName.setText("");
		ftfAuthorName.setBounds(551, 120, 242, 20);
		frame.getContentPane().add(ftfAuthorName);

		btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String authorName = ftfAuthorName.getText();

				searchResult = CoAuthorSearchUtils.getCoAuthorSearchResults(authorName);
				filterResult = null;

				displayAndFilterSearchResults();
			}
		});
		btnSearch.setForeground(new Color(0, 0, 102));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(551, 160, 242, 30);
		frame.getContentPane().add(btnSearch);

		lblAuthorName = new JLabel("AUTHOR NAME");
		lblAuthorName.setForeground(new Color(0, 0, 102));
		lblAuthorName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAuthorName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblAuthorName.setBounds(359, 123, 116, 14);
		frame.getContentPane().add(lblAuthorName);

	}

	public void displayAndFilterSearchResults(){

		if (scrollerFlag){
			frame.getContentPane().remove(scroller);
			frame.getContentPane().remove(btnaddFavoriteAuthor);
			frame.getContentPane().remove(ftfAuthorNameContains);
			frame.getContentPane().remove(ftfMinimumPublication);
			frame.getContentPane().remove(btnFilter);
			scrollerFlag = false;
		}
		
		if (!authorNameContainsFlag){
			JLabel lblAuthorNameContains = new JLabel("AUTHOR NAME CONTAINS");
			lblAuthorNameContains.setBounds(150, 300, 176, 20);
			lblAuthorNameContains.setForeground(new Color(0, 0, 102));
			lblAuthorNameContains.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
			frame.getContentPane().add(lblAuthorNameContains);
			authorNameContainsFlag = true;
		}

		ftfAuthorNameContains = new JFormattedTextField();
		ftfAuthorNameContains.setForeground(new Color(0, 0, 102));
		ftfAuthorNameContains.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		ftfAuthorNameContains.setText("");
		ftfAuthorNameContains.setBounds(326, 300, 200, 20);
		frame.getContentPane().add(ftfAuthorNameContains);

		if (!minimumPublicationFlag){
			JLabel lblMinimumPublication = new JLabel("MINIMUM PUBLICATION");
			lblMinimumPublication.setBounds(573, 300, 165, 20);
			lblMinimumPublication.setForeground(new Color(0, 0, 102));
			lblMinimumPublication.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
			frame.getContentPane().add(lblMinimumPublication);
			minimumPublicationFlag = true;
		}
			
		ftfMinimumPublication = new JFormattedTextField();
		ftfMinimumPublication.setForeground(new Color(0, 0, 102));
		ftfMinimumPublication.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		ftfMinimumPublication.setText("");
		ftfMinimumPublication.setBounds(738, 300, 200, 20);
		frame.getContentPane().add(ftfMinimumPublication);
		
		if (!displayingResultsFlag){
			lblDisplayingResults = new JLabel("DISPLAYING RESULTS");
			lblDisplayingResults.setBounds(150, 345, 200, 20);
			lblDisplayingResults.setForeground(new Color(0, 0, 102));
			lblDisplayingResults.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
			frame.getContentPane().add(lblDisplayingResults);
			displayingResultsFlag = true;
		}
		
		JPanel authorDisplayArea = new JPanel();
		authorDisplayArea.setLayout(new BoxLayout(authorDisplayArea, BoxLayout.Y_AXIS));

		scroller = new JScrollPane(authorDisplayArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setBounds(150, 370, 1000, 300);
		frame.getContentPane().add(scroller);
		scrollerFlag = true;
		
		btnFilter = new JButton("APPLY FILTERS");
		btnFilter.setBackground(new Color(255, 255, 255));
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filterResult = FilterUtils.getFilteredResult(ftfAuthorNameContains.getText(), ftfMinimumPublication.getText(), searchResult);

				displayAndFilterSearchResults();
			}
		});
		btnFilter.setForeground(new Color(0, 0, 102));
		btnFilter.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnFilter.setBounds(950, 295, 200, 30);
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

		btnaddFavoriteAuthor = new JButton("ADD TO FAVORITES");
		btnaddFavoriteAuthor.setBackground(new Color(255, 255, 255));
		btnaddFavoriteAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = searchResultTable.getSelectedRow();

				if(row > 0){
					String authorName = (String) searchResultTable.getValueAt(row,0);
					
					ResponseMessage rm = FavoriteAuthorUtils.addAuthorToFavouriteList(authorName);
					if(!rm.isSuccess())
						JOptionPane.showMessageDialog(getFrame(), rm.getMessage());
					else
						JOptionPane.showMessageDialog(getFrame(), authorName + " added!!");

				}
			}
		});
		btnaddFavoriteAuthor.setForeground(new Color(0, 0, 102));
		btnaddFavoriteAuthor.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		btnaddFavoriteAuthor.setBounds(573, 331, 200, 30);
		frame.getContentPane().add(btnaddFavoriteAuthor);

		model.addColumn("Person Name"); 
		model.addColumn("Publication Title");
		model.addColumn("Publication Type");
		model.addColumn("Publication Year");
		model.addColumn("Journal/Publication/Conference");
		
		Font font = new Font("Microsoft JhengHei UI", Font.BOLD, 11);
		
		AttributedString personName = new AttributedString("PERSON NAME");
		personName.addAttribute(TextAttribute.FONT, font);
		
		AttributedString publicationTitle = new AttributedString("PUBLICATION TITLE");
		publicationTitle.addAttribute(TextAttribute.FONT, font);
		
		AttributedString publicationType = new AttributedString("PUBLICATION TYPE");
		publicationType.addAttribute(TextAttribute.FONT, font);
		
		AttributedString publicationYear = new AttributedString("PUBLICATION YEAR");
		publicationYear.addAttribute(TextAttribute.FONT, font);
		
		AttributedString journal = new AttributedString("JOURNAL/PUBLICATION/CONFERENCE");
		journal.addAttribute(TextAttribute.FONT, font);

		model.addRow(new Object[]{personName,publicationTitle,publicationType,publicationYear,journal});

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
		else
			model.addRow(new Object[]{"NO RESULTS TO DISPLAY"});

		frame.repaint();
		
	}
}