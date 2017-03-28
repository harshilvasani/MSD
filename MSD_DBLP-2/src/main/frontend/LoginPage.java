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

		app = App.getTestAppInstance(10);

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 255, 0));
		frame.setBounds(0, 0, 1350, 725);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// register button used to go to the register page
		btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 255, 0));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage rp = new RegisterPage();

				JFrame registerPageFrame = rp.getFrame();

				if(registerPageFrame != null){
					registerPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}
				else
					lblError.setText("Error in creating L Page");
			}
		});
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRegister.setBounds(575, 187, 200, 70);
		frame.getContentPane().add(btnRegister);

		lblOr = new JLabel("OR");
		lblOr.setBackground(Color.WHITE);
		lblOr.setForeground(new Color(0, 255, 0));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOr.setBounds(650, 282, 50, 30);
		frame.getContentPane().add(lblOr);

		lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 255, 0));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogin.setBounds(575, 312, 200, 70);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblLogin);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setForeground(new Color(0, 255, 0));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(475, 392, 400, 15);
		frame.getContentPane().add(lblUsername);

		ftfUsername = new JFormattedTextField();
		ftfUsername.setBounds(635, 407, 80, 20);
		frame.getContentPane().add(ftfUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setForeground(new Color(0, 255, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(475, 437, 400, 15);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(635, 452, 80, 20);
		frame.getContentPane().add(passwordField);

		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblError.setForeground(new Color(0, 255, 0));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(475, 482, 400, 20);
		frame.getContentPane().add(lblError);

		// sign in button
		btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignIn.setBackground(new Color(255, 255, 255));
		btnSignIn.setForeground(new Color(0, 255, 0));
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
							lblError.setText("Error in creating Profile Page");

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

		btnSignIn.setBounds(625, 512, 100, 25);
		frame.getContentPane().add(btnSignIn);	
	}

	private void changeLabels(Boolean isValidUsername, Boolean isValidPassword){

		// function to change appropriate labels in case of syntax error in input from user
		if(isValidUsername)	
			lblUsername.setText("Username");

		else	
			lblUsername.setText("Username <Should contain only letters, digits or '_'>");

		if(isValidPassword)	
			lblPassword.setText("Password");

		else	
			lblPassword.setText("Password should contain letters and digits. Length>7");

		lblError.setText("");

	}
}
