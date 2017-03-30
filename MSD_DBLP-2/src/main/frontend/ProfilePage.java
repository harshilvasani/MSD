package frontend;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.User;
import validator.utils.Validator;

public class ProfilePage{

	private App app;
	private User loggedInUser;

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
	private JLabel lblProfile;
	private JFormattedTextField ftfFullName;
	private JFormattedTextField ftfEmailID;
	private JFormattedTextField ftfUsername;
	private JPasswordField pwdPassword;
	private JPasswordField pwdVerifyPassword;
	private JFormattedTextField ftfPhoneNumber;
	private JLabel lblFullName;
	private JLabel lblEmailID;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblVerifyPassword;
	private JLabel lblPhoneNumber;
	private JButton btnUpdate;
	private JLabel lblError;

	public ProfilePage() {
		app = App.getAppInstance();
		loggedInUser = app.getLoggedInUser();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		int WIDTH = 1350;
		int HEIGHT = 725;
		int LABEL_WIDTH = 360;
		int LABEL_HEIGHT = 20;
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				else
					lblError.setText("ERROR IN CREATING LOGIN PAGE");

			}
		});
		frame.getContentPane().setLayout(null);
		btnLogout.setForeground(new Color(0, 0, 102));
		btnLogout.setBounds(1075, 10, 200, 25);
		frame.getContentPane().add(btnLogout);

		btnProfile = new JButton(loggedInUser.getFullName().toUpperCase());//("PROFILE");
		btnProfile.setBorder(new LineBorder(new Color(0, 0, 102)));
		btnProfile.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		btnProfile.setBackground(new Color(0, 0, 102));
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
				else
					lblError.setText("ERROR IN CREATING FAVORITES LIST PAGE");
				
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
				else
					lblError.setText("ERROR IN CREATING AUTHOR SEARCH PAGE");

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
				else
					lblError.setText("ERROR IN CREATING CO AUTHOR PAGE");

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
				else
					lblError.setText("ERROR IN CREATING SIMILAR AUTHOR PAGE");

			}
		});
		btnSimilarAuthorSearch.setForeground(new Color(0, 0, 102));
		btnSimilarAuthorSearch.setBounds(475, 10, 200, 25);
		frame.getContentPane().add(btnSimilarAuthorSearch);

		ftfFullName = new JFormattedTextField();
		ftfFullName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfFullName.setForeground(new Color(0, 0, 102));
		ftfFullName.setBounds(495, 160, 360, 30);
		frame.getContentPane().add(ftfFullName);
		ftfFullName.setColumns(10);

		ftfEmailID = new JFormattedTextField();
		ftfEmailID.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfEmailID.setForeground(new Color(0, 0, 102));
		ftfEmailID.setBounds(495, 220, 360, 30);
		frame.getContentPane().add(ftfEmailID);
		ftfEmailID.setColumns(10);

		ftfUsername = new JFormattedTextField();
		ftfUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfUsername.setForeground(new Color(0, 0, 102));
		ftfUsername.setBounds(495, 280, 360, 30);
		frame.getContentPane().add(ftfUsername);
		ftfUsername.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		pwdPassword.setForeground(new Color(0, 0, 102));
		pwdPassword.setBounds(495, 340, 360, 30);
		frame.getContentPane().add(pwdPassword);

		pwdVerifyPassword = new JPasswordField();
		pwdVerifyPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		pwdVerifyPassword.setForeground(new Color(0, 0, 102));
		pwdVerifyPassword.setBounds(495, 400, 360, 30);
		frame.getContentPane().add(pwdVerifyPassword);

		ftfPhoneNumber = new JFormattedTextField();
		ftfPhoneNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfPhoneNumber.setForeground(new Color(0, 0, 102));
		ftfPhoneNumber.setBounds(495, 460, 360, 30);
		frame.getContentPane().add(ftfPhoneNumber);
		ftfPhoneNumber.setColumns(10);

		lblProfile = new JLabel("PROFILE");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblProfile.setForeground(new Color(0, 0, 102));
		lblProfile.setBounds(495, 65, 360, 40);
		frame.getContentPane().add(lblProfile);

		lblFullName = new JLabel("FULL NAME");
		lblFullName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblFullName.setForeground(new Color(0, 0, 102));
		lblFullName.setBounds(495, 140, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblFullName);

		lblEmailID = new JLabel("EMAIL ID");
		lblEmailID.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblEmailID.setForeground(new Color(0, 0, 102));
		lblEmailID.setBounds(495, 200, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblEmailID);

		lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblUsername.setForeground(new Color(0, 0, 102));
		lblUsername.setBounds(495, 260, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblUsername);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblPassword.setForeground(new Color(0, 0, 102));
		lblPassword.setBounds(495, 320, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblPassword);

		lblVerifyPassword = new JLabel("VERIFY PASSWORD");
		lblVerifyPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblVerifyPassword.setForeground(new Color(0, 0, 102));
		lblVerifyPassword.setBounds(495, 380, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblVerifyPassword);

		lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblPhoneNumber.setForeground(new Color(0, 0, 102));
		lblPhoneNumber.setBounds(495, 440, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblPhoneNumber);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		lblError.setForeground(new Color(255, 0, 51));
		lblError.setBounds(495, 575, 360, 40);
		frame.getContentPane().add(lblError);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(0, 0, 102));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Boolean isValidFullName = Validator.isValidFullName(ftfFullName.getText());
				Boolean isValidEmailID = Validator.isValidEmailId(ftfEmailID.getText()); 
				Boolean isValidUsername = Validator.isValidUsername(ftfUsername.getText());
				Boolean isValidPassword = Validator.isValidPassword(String.valueOf(pwdPassword.getPassword()));
				Boolean isValidVerifyPassword = Validator.arebothPasswordSame(String.valueOf(pwdPassword.getPassword()), 
						String.valueOf(pwdVerifyPassword.getPassword()));
				Boolean isValidPhoneNumber = Validator.isValidPhoneNumber(ftfPhoneNumber.getText());

				if(isValidFullName && isValidEmailID && isValidUsername && isValidPassword && isValidVerifyPassword && isValidPhoneNumber){
					User updatedUser = new User();

					updatedUser.setId(loggedInUser.getId());
					updatedUser.setFullName(ftfFullName.getText()); 
					updatedUser.setEmailId(ftfEmailID.getText());
					updatedUser.setUsername(ftfUsername.getText());
					updatedUser.setPassword(String.valueOf(pwdPassword.getPassword())); 
					updatedUser.setPhoneNumber(ftfPhoneNumber.getText());
					
					ResponseMessage rm = app.updateProfile(updatedUser);
					lblError.setText(rm.getMessage());
				}
				
				else{
					changeLabels(isValidFullName, isValidEmailID, isValidUsername, isValidPassword, isValidVerifyPassword, isValidPhoneNumber);
				}
			}
		});
		
		btnUpdate.setVerticalTextPosition(AbstractButton.CENTER);
		btnUpdate.setHorizontalTextPosition(AbstractButton.CENTER);
		btnUpdate.setBounds(495, 515, 360, 40);
		frame.getContentPane().add(btnUpdate);
		

		ftfFullName.setText(loggedInUser.getFullName());
		ftfEmailID.setText(loggedInUser.getEmailId());
		ftfUsername.setText(loggedInUser.getUsername());
		pwdPassword.setText(loggedInUser.getPassword());
		pwdVerifyPassword.setText(loggedInUser.getPassword());
		ftfPhoneNumber.setText(loggedInUser.getPhoneNumber());

	}
	private void changeLabels(Boolean isValidFullName, Boolean isValidEmailID, Boolean isValidUsername, Boolean isValidPassword, 
			Boolean isValidVerifyPassword, Boolean isValidPhoneNumber){
		
		if(isValidFullName){	
			lblFullName.setText("FULL NAME");
			lblFullName.setForeground(new Color(0, 0, 102));
		}
		else{
			lblFullName.setText("FULL NAME <PLEASE ENTER VALID FULL NAME>");
			lblFullName.setForeground(new Color(255, 0, 51));
		}
		
		if(isValidEmailID){
			lblEmailID.setText("EMAIL ID");
			lblEmailID.setForeground(new Color(0, 0, 102));
		}
		else{
			lblEmailID.setText("EMAIL ID <PLEASE ENTER VALID EMAIL ID>");
			lblEmailID.setForeground(new Color(255, 0, 51));
		}
		
		if(isValidUsername){
			lblUsername.setText("USERNAME");
			lblUsername.setForeground(new Color(0, 0, 102));
		}
		else{
			lblUsername.setText("USERNAME <SHOULD CONTAIN ONLY LETTERS, DIGITS OR '_'>");
			lblUsername.setForeground(new Color(255, 0, 51));
		}
		
		if(isValidPassword){
			lblPassword.setText("PASSWORD");
			lblError.setForeground(new Color(0, 0, 102));
		}
		else{
			lblPassword.setText("PASSWORD <SHOULD CONTAIN LETTERS AND DIGITS. LENGTH > 7>");
			lblPassword.setForeground(new Color(255, 0, 51));
		}
		
		if(isValidVerifyPassword){
			lblVerifyPassword.setText("VERIFY PASSWORD");
			lblVerifyPassword.setForeground(new Color(0, 0, 102));
		}
		else{
			lblVerifyPassword.setText("VERIFY PASSWORD <DID NOT MATCH PASSWORD>");
			lblVerifyPassword.setForeground(new Color(255, 0, 51));
		}
		
		if(isValidPhoneNumber){
			lblPhoneNumber.setText("PHONE NUMBER");
			lblPhoneNumber.setForeground(new Color(0, 0, 102));
		}
		else{
			lblPhoneNumber.setText("PHONE NUMBER <SHOULD CONTAIN EXACTLY 10 DIGITS>");
			lblPhoneNumber.setForeground(new Color(255, 0, 51));
		}
		
		lblError.setText("");

	}
}