package frontend;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Profile_Page{

	JFrame frame;
	JButton btnLogout;
	JButton btnProfile;
	JButton btnFavorites;
	JButton btnAuthorSearch;
	JButton btnCoAuthorSearch;
	JButton btnSimilarAuthorSearch;
	String fontStyle = "";
	String fontColor = "";
	JLabel lblProfile;
	JFormattedTextField ftfFullName;
	JFormattedTextField ftfEmailID;
	JFormattedTextField ftfUsername;
	JPasswordField pwdPassword;
	JPasswordField pwdVerifyPassword;
	JFormattedTextField ftfPhoneNumber;
	JLabel lblFullName;
	JLabel lblEmailID;
	JLabel lblUsername;
	JLabel lblPassword;
	JLabel lblVerifyPassword;
	JLabel lblPhoneNumber;
	JButton btnUpdate;
	JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile_Page window = new Profile_Page();
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
	public Profile_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int Y = 100;
		int WIDTH = 1350;
		int HEIGHT = 725;
		int HALF_WIDTH = WIDTH/2;
		int HALF_HEIGHT = HEIGHT/2;
		int TEXT_FIELD_WIDTH = 360;
		int TEXT_FIELD_HEIGHT = 20;
		int LABEL_WIDTH = 360;
		int LABEL_HEIGHT = 20;
		int BUTTON_WIDTH = 80;
		int BUTTON_HEIGHT = 20;
		int TEXT_FIELD_X = HALF_WIDTH-(TEXT_FIELD_WIDTH/2);
		int LABEL_X = HALF_WIDTH-(TEXT_FIELD_WIDTH/2);
		int BUTTON_X = HALF_WIDTH-(BUTTON_WIDTH/2);
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				Search_Page sp = new Search_Page();
				sp.frame.setVisible(true);
				frame.setVisible(false);
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
		
		ftfFullName = new JFormattedTextField();
		ftfFullName.setBounds(TEXT_FIELD_X, Y+120, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		frame.getContentPane().add(ftfFullName);
		ftfFullName.setColumns(10);
		
		ftfEmailID = new JFormattedTextField();
		ftfEmailID.setBounds(TEXT_FIELD_X, Y+170, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		frame.getContentPane().add(ftfEmailID);
		ftfEmailID.setColumns(10);
		
		ftfUsername = new JFormattedTextField();
		ftfUsername.setBounds(TEXT_FIELD_X, Y+220, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		frame.getContentPane().add(ftfUsername);
		ftfUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(TEXT_FIELD_X, Y+270, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		frame.getContentPane().add(pwdPassword);
		
		pwdVerifyPassword = new JPasswordField();
		pwdVerifyPassword.setBounds(TEXT_FIELD_X, Y+320, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		frame.getContentPane().add(pwdVerifyPassword);
		
		ftfPhoneNumber = new JFormattedTextField();
		ftfPhoneNumber.setBounds(TEXT_FIELD_X, Y+370, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		frame.getContentPane().add(ftfPhoneNumber);
		ftfPhoneNumber.setColumns(10);
		
		lblProfile = new JLabel("PROFILE");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblProfile.setForeground(new Color(0, 255, 0));
		lblProfile.setBounds(603, 135, 144, 28);
		frame.getContentPane().add(lblProfile);
		
		lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(0, 255, 0));
		lblFullName.setBounds(LABEL_X, Y+100, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblFullName);
		
		lblEmailID = new JLabel("Email ID");
		lblEmailID.setForeground(new Color(0, 255, 0));
		lblEmailID.setBounds(LABEL_X, Y+150, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblEmailID);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 255, 0));
		lblUsername.setBounds(LABEL_X, Y+200, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 255, 0));
		lblPassword.setBounds(LABEL_X, Y+250, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblPassword);
		
		lblVerifyPassword = new JLabel("Verify Password");
		lblVerifyPassword.setForeground(new Color(0, 255, 0));
		lblVerifyPassword.setBounds(LABEL_X, Y+300, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblVerifyPassword);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 255, 0));
		lblPhoneNumber.setBounds(LABEL_X, Y+350, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblPhoneNumber);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(0, 255, 0));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(LABEL_X, Y+400, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblError);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(0, 255, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				User user = new User();
				user.setFullName(ftfFullName.getText()); 
				user.setEmailID(ftfEmailID.getText());
				user.setUsername(ftfUsername.getText());
				user.setPassword(pwdPassword.getPassword());
				user.setVerifyPassword(pwdVerifyPassword.getPassword()); 
				user.setPhoneNumber(ftfPhoneNumber.getText());
				
				Boolean isValidFullName = user.checkFullName();
				Boolean isValidEmailID = user.checkEmailID(); 
				Boolean isValidUsername = user.checkUsername();
				Boolean isValidPassword = user.checkPassword();
				Boolean isValidVerifyPassword = user.checkVerifyPassword();
				Boolean isValidPhoneNumber = user.checkPhoneNumber();
				
				if(isValidFullName && isValidEmailID && isValidUsername && isValidPassword && isValidVerifyPassword && isValidPhoneNumber){
					if(user.sendToUpdateInterfacing()){
						Search_Page sp = new Search_Page();
						sp.frame.setVisible(true);
						frame.setVisible(false);
					}
					else{
						lblError.setText("Some error has occured, please try later");
					}
				}
				else{
					changeLabels(isValidFullName, isValidEmailID, isValidUsername, isValidPassword, isValidVerifyPassword, isValidPhoneNumber);
				}
			}
		});
		btnUpdate.setVerticalTextPosition(AbstractButton.CENTER);
		btnUpdate.setHorizontalTextPosition(AbstractButton.CENTER);
		btnUpdate.setBounds(BUTTON_X, Y+435, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(btnUpdate);
				
	}
	private void changeLabels(Boolean isValidFullName, Boolean isValidEmailID, Boolean isValidUsername, Boolean isValidPassword, 
			Boolean isValidVerifyPassword, Boolean isValidPhoneNumber){
		
		if(isValidFullName)	lblFullName.setText("Full Name");
		else	lblFullName.setText("Full Name <Please enter valid full name>");
		if(isValidEmailID)	lblEmailID.setText("Email ID");
		else	lblEmailID.setText("Email ID <Please enter valid Email ID>");
		if(isValidUsername)	lblUsername.setText("Username");
		else	lblUsername.setText("Username <Should contain only letters, digits or '_'>");
		if(isValidPassword)	lblPassword.setText("Password");
		else	lblPassword.setText("Password <Should contain letters and digits. Length>7>");
		if(isValidVerifyPassword)	lblVerifyPassword.setText("Verify Password");
		else	lblVerifyPassword.setText("Verify Password <Did not match Password>");
		if(isValidPhoneNumber)	lblPhoneNumber.setText("Phone Number");
		else	lblPhoneNumber.setText("Phone Number <Should contain 10 digits>");
		lblError.setText("");
		
	}
}