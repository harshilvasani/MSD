package frontend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Search_Page {

	JFrame frame;
	JButton btnLogout;
	JButton btnProfile;
	JButton btnFavorites;
	JButton btnAuthorSearch;
	JButton btnCoAuthorSearch;
	JButton btnSimilarAuthorSearch;
	JLabel lblAuthorSearch;
	JFormattedTextField ftfSearchCriteria;
	JLabel lblSearchOption;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton radioButton_1;
	JRadioButton radioButton_2;
	JRadioButton radioButton_3;
	JRadioButton radioButton_4;
	Boolean R1;
	Boolean R2;
	Boolean R3;
	Boolean R4;
	JButton btnSearch;

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
		
		R1=false; R2=false; R3=false; R4=false;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 0, 1350, 725);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		ftfSearchCriteria = new JFormattedTextField();
		ftfSearchCriteria.setForeground(new Color(0, 255, 0));
		ftfSearchCriteria.setText("Enter Search Criteria");
		ftfSearchCriteria.setBounds(150, 120, 200, 20);
		frame.getContentPane().add(ftfSearchCriteria);

		lblSearchOption = new JLabel("Search Option");
		lblSearchOption.setForeground(new Color(0, 255, 0));
		lblSearchOption.setBounds(150, 160, 200, 20);
		frame.getContentPane().add(lblSearchOption);
		
		radioButton_1 = new JRadioButton("R1");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R1 = true;
				R2 = false;
				R3 = false;
				R4 = false;
			}
		});
		radioButton_1.setBackground(new Color(255, 255, 255));
		radioButton_1.setForeground(new Color(0, 255, 0));
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(150, 180, 200, 20);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("R2");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R1 = true;
				R2 = false;
				R3 = false;
				R4 = false;
			}
		});
		radioButton_2.setBackground(new Color(255, 255, 255));
		radioButton_2.setForeground(new Color(0, 255, 0));
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(150, 200, 200, 20);
		frame.getContentPane().add(radioButton_2);
		
		radioButton_3 = new JRadioButton("R3");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R1 = false;
				R2 = false;
				R3 = true;
				R4 = false;
			}
		});
		radioButton_3.setForeground(Color.GREEN);
		radioButton_3.setBackground(Color.WHITE);
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(150, 220, 200, 20);
		frame.getContentPane().add(radioButton_3);
		
		radioButton_4 = new JRadioButton("R4");
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R1 = false;
				R2 = false;
				R3 = false;
				R4 = true;
			}
		});
		radioButton_4.setForeground(Color.GREEN);
		radioButton_4.setBackground(Color.WHITE);
		buttonGroup.add(radioButton_4);
		radioButton_4.setBounds(150, 240, 200, 20);
		frame.getContentPane().add(radioButton_4);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SearchCriteria = ftfSearchCriteria.getText();
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(195, 270, 110, 25);
		frame.getContentPane().add(btnSearch);
		
		
	}
}
