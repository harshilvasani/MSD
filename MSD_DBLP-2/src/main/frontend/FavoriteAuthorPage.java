package frontend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import frontend.utils.FavoriteAuthorUtils;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.FavouriteAuthor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.List;
import java.awt.event.ActionEvent;

public class FavoriteAuthorPage {

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
	private JButton btnDisplayStatistics;
	private JButton btnRemoveFavorite;
	private JLabel lblFavoriteAuthorsList;
	private JScrollPane scroller;
	private JPanel authorDisplayArea;
	private DefaultTableModel model;
	private JTable favoriteAuthorsTable;
	private Boolean isTableDisplayed;

	public FavoriteAuthorPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(0, 0, 1350, 750);
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

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
		btnProfile.setBorder(null);
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
		btnFavorites.setBorder(new LineBorder(new Color(0, 0, 102)));
		btnFavorites.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		btnFavorites.setBackground(new Color(0, 0, 102));
		
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
		btnCoAuthorSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
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


		lblFavoriteAuthorsList = new JLabel("FAVORITE AUTHORS LIST");
		lblFavoriteAuthorsList.setForeground(new Color(0, 0, 102));
		lblFavoriteAuthorsList.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoriteAuthorsList.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblFavoriteAuthorsList.setBounds(485, 45, 380, 75);
		frame.getContentPane().add(lblFavoriteAuthorsList);

		btnDisplayStatistics = new JButton("DISPLAY STATISTICS");
		btnDisplayStatistics.setForeground(new Color(0, 0, 102));
		btnDisplayStatistics.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		btnDisplayStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayStatisticsPage ds = new DisplayStatisticsPage();

				JFrame displayStatisticsFrame = ds.getFrame();

				if(displayStatisticsFrame != null){
					displayStatisticsFrame.setVisible(true);
					getFrame().setVisible(false);
				}

			}
		});
		btnDisplayStatistics.setBounds(485, 140, 380, 40);
		frame.getContentPane().add(btnDisplayStatistics);
		
		isTableDisplayed = false;


		displayFavoriteAuthors();
		
	}

	@SuppressWarnings("serial")
	private void displayFavoriteAuthors(){

		List<FavouriteAuthor> favAuthorList = FavoriteAuthorUtils.getFavoriteAuthors();

		if ( favAuthorList.size() > 0 ){
			if( isTableDisplayed ){

				frame.getContentPane().remove(btnRemoveFavorite);
				frame.getContentPane().remove(scroller);
				isTableDisplayed = false;

			}
			
			btnRemoveFavorite = new JButton("REMOVE FAVORITE");
			btnRemoveFavorite.setForeground(new Color(0, 0, 102));
			btnRemoveFavorite.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
			btnRemoveFavorite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					int row = favoriteAuthorsTable.getSelectedRow();

					if(row == 1){
						String authorName = (String) favoriteAuthorsTable.getValueAt(row,0);

						ResponseMessage rm = FavoriteAuthorUtils.removeAuthorToFavouriteList(authorName);
						if(!rm.isSuccess())
							JOptionPane.showMessageDialog(getFrame(), rm.getMessage());
						else
							JOptionPane.showMessageDialog(getFrame(), authorName + " removed!!");
					}

					displayFavoriteAuthors();
				}
			});
			btnRemoveFavorite.setBounds(485, 200, 380, 40);
			frame.getContentPane().add(btnRemoveFavorite);

			authorDisplayArea = new JPanel();
			authorDisplayArea.setLayout(new BoxLayout(authorDisplayArea, BoxLayout.Y_AXIS));

			scroller = new JScrollPane(authorDisplayArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroller.setBounds(150, 260, 1000, 410);
			frame.getContentPane().add(scroller);

			model = new DefaultTableModel(){

				@Override
				public boolean isCellEditable(int i, int i1) {
					return false; //To change body of generated methods, choose Tools | Templates.
				}

			};

			favoriteAuthorsTable = new JTable(model);
			isTableDisplayed = true;
			authorDisplayArea.add(favoriteAuthorsTable);

			model.addColumn("Person Name");

			Font font = new Font("Microsoft JhengHei UI", Font.BOLD, 11);
			
			AttributedString personName = new AttributedString("PERSON NAME");
			personName.addAttribute(TextAttribute.FONT, font);
			
			model.addRow(new Object[]{personName});

			for( int i = 0; i < favAuthorList.size() ; i++ ){

				FavouriteAuthor favoriteAuthor = (FavouriteAuthor) favAuthorList.get(i);

				model.addRow(new Object[]{favoriteAuthor.getAuthorName()});
			}
			
		}
		else
			model.addRow(new Object[]{"NO RESULTS TO DISPLAY"});
		
		frame.repaint();

	}
}
