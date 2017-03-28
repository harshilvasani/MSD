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

	private App aap;

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
		aap = App.getTestAppInstance(10);
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

		lblRegister = new JLabel("REGISTER");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegister.setForeground(new Color(0, 255, 0));
		lblRegister.setBounds(603, 135, 144, 28);
		frame.getContentPane().add(lblRegister);

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

		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setForeground(new Color(0, 255, 0));
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
					ResponseMessage rm = aap.register(newUser);
					if(rm.isSuccess()){
						LoginPage lp = new LoginPage();

						JFrame loginPageFrame = lp.getFrame();

						if(loginPageFrame != null){
							loginPageFrame.setVisible(true);
							getFrame().setVisible(false);
						}
						else
							lblError.setText("Error in creating Login Page");
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
		btnSubmit.setBounds(BUTTON_X, Y+435, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(btnSubmit);

		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setForeground(new Color(0, 255, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage lp = new LoginPage();

				JFrame loginPageFrame = lp.getFrame();

				if(loginPageFrame != null){
					loginPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
				else
					lblError.setText("Error in creating Login Page");
			}
		});
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setBounds(BUTTON_X, Y+475, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(btnBack);

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
