package frontend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import backend.BackEnd;
import resources.person.Author;
import resources.person.IPerson;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

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
	JFormattedTextField formattedTextField;
	JFormattedTextField formattedTextField_1;
	JFormattedTextField formattedTextField_2;
	JButton btnSearch;
	JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BackEnd b = new BackEnd();
		b.loadData(0);
		System.out.println("Data LoADED");
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
		
	//	R1=false; R2=false; R3=false; R4=false;
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
		ftfSearchCriteria.setText("");
		ftfSearchCriteria.setBounds(150, 120, 200, 20);
		frame.getContentPane().add(ftfSearchCriteria);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setText("");
		formattedTextField.setForeground(Color.GREEN);
		formattedTextField.setBounds(150, 151, 200, 20);
		frame.getContentPane().add(formattedTextField);
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("");
		formattedTextField_1.setForeground(Color.GREEN);
		formattedTextField_1.setBounds(150, 182, 200, 20);
		frame.getContentPane().add(formattedTextField_1);
		
		formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setText("");
		formattedTextField_2.setForeground(Color.GREEN);
		formattedTextField_2.setBounds(150, 213, 200, 20);
		frame.getContentPane().add(formattedTextField_2);
		

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String publicationTitle = ftfSearchCriteria.getText();
				String journalName = formattedTextField.getText();
				String minYear = formattedTextField_1.getText();
				String absence = formattedTextField_2.getText();
				
				Interfacing_for_Author_Search authorSearchComm = new Interfacing_for_Author_Search(
						publicationTitle, journalName, minYear, absence);
				
				List<IPerson> result = authorSearchComm.sendSearchCriteriaToApp();
				
				String display = "";
				
				for(int i=0; i<result.size(); i++){
					IPerson person = result.get(i);
					if(person instanceof Author){
						Author a = (Author) person;
						display += a.toString();
						display += ";\n";
					}
				}
				
				textField.setText(display);
				
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(192, 244, 110, 25);
		frame.getContentPane().add(btnSearch);
		
		
		textField = new JTextField();
		textField.setBounds(150, 376, 200, 144);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	/*	
		JButton button = new JButton("Search");
		button.setForeground(Color.GREEN);
		button.setBackground(Color.WHITE);
		button.setBounds(24, 305, 110, 25);
		frame.getContentPane().add(button);
		*/
		JLabel lblDisplayingResults = new JLabel("Displaying Results");
		lblDisplayingResults.setBounds(151, 345, 86, 14);
		frame.getContentPane().add(lblDisplayingResults);
		
		JLabel lblPublicationTitle = new JLabel("Publication Title");
		lblPublicationTitle.setBounds(24, 123, 116, 14);
		frame.getContentPane().add(lblPublicationTitle);
		
		JLabel lblJournalName = new JLabel("Journal Name");
		lblJournalName.setBounds(24, 154, 116, 14);
		frame.getContentPane().add(lblJournalName);
		
		JLabel lblMinimumYear = new JLabel("Minimum Year");
		lblMinimumYear.setBounds(24, 185, 116, 14);
		frame.getContentPane().add(lblMinimumYear);
		
		JLabel lblAbsenceFromCommittee = new JLabel("Absence from Committee");
		lblAbsenceFromCommittee.setBounds(24, 216, 116, 14);
		frame.getContentPane().add(lblAbsenceFromCommittee);
		
		
	}
}
