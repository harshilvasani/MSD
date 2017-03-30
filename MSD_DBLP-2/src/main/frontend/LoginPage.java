package frontend;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import validator.utils.Validator;

import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage {

	public static App app;

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JButton btnRegister;
	private JLabel lblOr;
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JFormattedTextField ftfUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnSignIn;
	private JLabel lblError;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage(){

		app = App.getAppInstance();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.setBounds(0, 0, 1350, 725);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// register button used to go to the register page
		btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(new Color(0, 0, 102));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage rp = new RegisterPage();

				JFrame registerPageFrame = rp.getFrame();

				if(registerPageFrame != null){
					registerPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
				else
					lblError.setText("ERROR IN CREATING PROFILE PAGE");
			}
		});
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		btnRegister.setBounds(575, 110, 200, 70);
		frame.getContentPane().add(btnRegister);

		lblOr = new JLabel("OR");
		lblOr.setBackground(Color.WHITE);
		lblOr.setForeground(new Color(0, 0, 102));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblOr.setBounds(650, 200, 50, 70);
		frame.getContentPane().add(lblOr);

		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(0, 0, 102));
		lblLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblLogin.setBounds(575, 290, 200, 70);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblLogin);

		lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		lblUsername.setForeground(new Color(0, 0, 102));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(475, 375, 400, 40);
		frame.getContentPane().add(lblUsername);

		ftfUsername = new JFormattedTextField();
		ftfUsername.setForeground(new Color(0, 0, 102));
		ftfUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		ftfUsername.setBounds(575, 415, 200, 40);
		frame.getContentPane().add(ftfUsername);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		lblPassword.setForeground(new Color(0, 0, 102));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(475, 455, 400, 40);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 102));
		passwordField.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		passwordField.setBounds(575, 495, 200, 40);
		frame.getContentPane().add(passwordField);

		lblError = new JLabel("");
		lblError.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		lblError.setForeground(new Color(255, 0, 51));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(475, 617, 400, 40);
		frame.getContentPane().add(lblError);

		// sign in button
		btnSignIn = new JButton("SIGN IN");
		btnSignIn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		btnSignIn.setBackground(new Color(255, 255, 255));
		btnSignIn.setForeground(new Color(0, 0, 102));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// onclick it stores all the user information in the frontend user class

				String username = ftfUsername.getText();
				String password = String.valueOf(passwordField.getPassword());

				// syntax checks performed by the user class
				Boolean isValidUsername = Validator.isValidUsername(username);
				Boolean isValidPassword = Validator.isValidPassword(password);

				// if the syntax is correct pass the user information to the interfacing class
				if(isValidUsername && isValidPassword){

					// if the data is correctly updated then go to the search page
					ResponseMessage loginMsg = app.login(ftfUsername.getText(), String.valueOf(passwordField.getPassword()));

					if(loginMsg.isSuccess()){

						ProfilePage pp = new ProfilePage();
						JFrame profilePageFrame = pp.getFrame();

						if(profilePageFrame != null){
							profilePageFrame.setVisible(true);
							getFrame().setVisible(false);
						}
						else
							lblError.setText("ERROR IN CREATING PROFILE PAGE");

					}
					else{
						lblError.setText(loginMsg.getMessage());
					}
				}

				// if the syntax is not correct change the appropriate labels
				else{
					changeLabels(isValidUsername, isValidPassword);
				}
			}
		});

		btnSignIn.setBounds(575, 557, 200, 40);
		frame.getContentPane().add(btnSignIn);	
	}

	private void changeLabels(Boolean isValidUsername, Boolean isValidPassword){

		// function to change appropriate labels in case of syntax error in input from user
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
			lblPassword.setForeground(new Color(0, 0, 102));	
		}

		else{	
			lblPassword.setText("PASSWORD <SHOULD CONTAIN LETTERS AND DIGITS. LENGTH > 7.");
			lblPassword.setForeground(new Color(255, 0, 51));
		}

		lblError.setText("");

	}
}
