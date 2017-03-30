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

import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.User;
import validator.utils.Validator;

public class RegisterPage {

	private App app;

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JLabel lblRegister;
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
	private JButton btnSubmit;
	private JButton btnBack;
	private JLabel lblError;

	public RegisterPage() {
		app = App.getAppInstance();
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

		ftfFullName = new JFormattedTextField();
		ftfFullName.setForeground(new Color(0, 0, 102));
		ftfFullName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfFullName.setBounds(495, 160, 360, 30);
		frame.getContentPane().add(ftfFullName);
		ftfFullName.setColumns(10);

		ftfEmailID = new JFormattedTextField();
		ftfEmailID.setForeground(new Color(0, 0, 102));
		ftfEmailID.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfEmailID.setBounds(495, 220, 360, 30);
		frame.getContentPane().add(ftfEmailID);
		ftfEmailID.setColumns(10);

		ftfUsername = new JFormattedTextField();
		ftfUsername.setForeground(new Color(0, 0, 102));
		ftfUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfUsername.setBounds(495, 280, 360, 30);
		frame.getContentPane().add(ftfUsername);
		ftfUsername.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setForeground(new Color(0, 0, 102));
		pwdPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		pwdPassword.setBounds(495, 340, 360, 30);
		frame.getContentPane().add(pwdPassword);

		pwdVerifyPassword = new JPasswordField();
		pwdVerifyPassword.setForeground(new Color(0, 0, 102));
		pwdVerifyPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		pwdVerifyPassword.setBounds(495, 400, 360, 30);
		frame.getContentPane().add(pwdVerifyPassword);

		ftfPhoneNumber = new JFormattedTextField();
		ftfPhoneNumber.setForeground(new Color(0, 0, 102));
		ftfPhoneNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfPhoneNumber.setBounds(495, 460, 360, 30);
		frame.getContentPane().add(ftfPhoneNumber);
		ftfPhoneNumber.setColumns(10);

		lblRegister = new JLabel("REGISTER");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblRegister.setForeground(new Color(0, 0, 102));
		lblRegister.setBounds(495, 65, 360, 40);
		frame.getContentPane().add(lblRegister);

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
		lblError.setBounds(495, 630, 360, 40);
		frame.getContentPane().add(lblError);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setForeground(new Color(0, 0, 102));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Boolean isValidFullName = Validator.isValidFullName(ftfFullName.getText());
				Boolean isValidEmailID = Validator.isValidEmailId(ftfEmailID.getText()); 
				Boolean isValidUsername = Validator.isValidUsername(ftfUsername.getText());
				Boolean isValidPassword = Validator.isValidPassword(String.valueOf(pwdPassword.getPassword()));
				Boolean isValidVerifyPassword = Validator.arebothPasswordSame(String.valueOf(pwdPassword.getPassword()), 
						String.valueOf(pwdVerifyPassword.getPassword()));
				Boolean isValidPhoneNumber = Validator.isValidPhoneNumber(ftfPhoneNumber.getText());

				User newUser = new User();
				newUser.setFullName(ftfFullName.getText()); 
				newUser.setEmailId(ftfEmailID.getText());
				newUser.setUsername(ftfUsername.getText());
				newUser.setPassword(String.valueOf(pwdPassword.getPassword()));
				newUser.setPhoneNumber(ftfPhoneNumber.getText());

				if(isValidFullName && isValidEmailID && isValidUsername && isValidPassword && isValidVerifyPassword && isValidPhoneNumber){
					ResponseMessage rm = app.register(newUser);
					if(rm.isSuccess()){
						LoginPage lp = new LoginPage();

						JFrame loginPageFrame = lp.getFrame();

						if(loginPageFrame != null){
							loginPageFrame.setVisible(true);
							getFrame().setVisible(false);
						}
						else
							lblError.setText("ERROR IN CREATING LOGIN PAGE");
					}
					else
						lblError.setText(rm.getMessage());
				}
				else{
					changeLabels(isValidFullName, isValidEmailID, isValidUsername, isValidPassword, isValidVerifyPassword, isValidPhoneNumber);
				}
			}
		});
		btnSubmit.setVerticalTextPosition(AbstractButton.CENTER);
		btnSubmit.setHorizontalTextPosition(AbstractButton.CENTER);
		btnSubmit.setBounds(495, 515, 360, 40);
		frame.getContentPane().add(btnSubmit);

		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setForeground(new Color(0, 0, 102));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setBounds(495, 570, 360, 40);
		frame.getContentPane().add(btnBack);

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
