package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import backend.BackEnd;
import backend.parser.mysqldb.Database;
import persistence.HibernateUtil;
import queryengine.miscellaneous.ResponseMessage;
import validator.utils.Validator;

public class InstallPage {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JLabel lblInstall;
	private JFormattedTextField ftfHostName;
	private JPasswordField ftfPassword;
	private JFormattedTextField ftfUsername;
	private JFormattedTextField ftfDBLPLoc;
	private JFormattedTextField ftfCommitteeFolderPath;
	private JLabel lblHostName;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblDBLPLoc;
	private JLabel lblCommitteeFolderPath;
	private JButton btnInstall;
	private JButton btnSkip;
	private JLabel lblError;
	private JLabel lblLoading;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstallPage window = new InstallPage();
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
	public InstallPage() {
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

		ftfHostName = new JFormattedTextField();
		ftfHostName.setForeground(new Color(0, 0, 102));
		ftfHostName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfHostName.setBounds(495, 160, 360, 30);
		frame.getContentPane().add(ftfHostName);
		ftfHostName.setColumns(10);

		ftfUsername = new JFormattedTextField();
		ftfUsername.setForeground(new Color(0, 0, 102));
		ftfUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfUsername.setBounds(495, 220, 360, 30);
		frame.getContentPane().add(ftfUsername);
		ftfUsername.setColumns(10);

		ftfPassword = new JPasswordField();
		ftfPassword.setForeground(new Color(0, 0, 102));
		ftfPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfPassword.setBounds(495, 280, 360, 30);
		frame.getContentPane().add(ftfPassword);
		ftfPassword.setColumns(10);

		ftfDBLPLoc = new JFormattedTextField();
		ftfDBLPLoc.setForeground(new Color(0, 0, 102));
		ftfDBLPLoc.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfDBLPLoc.setBounds(495, 340, 360, 30);
		frame.getContentPane().add(ftfDBLPLoc);

		ftfCommitteeFolderPath = new JFormattedTextField();
		ftfCommitteeFolderPath.setForeground(new Color(0, 0, 102));
		ftfCommitteeFolderPath.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		ftfCommitteeFolderPath.setBounds(495, 400, 360, 30);
		frame.getContentPane().add(ftfCommitteeFolderPath);
		ftfCommitteeFolderPath.setColumns(10);

		lblInstall = new JLabel("INSTALL");
		lblInstall.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstall.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblInstall.setForeground(new Color(0, 0, 102));
		lblInstall.setBounds(495, 65, 360, 40);
		frame.getContentPane().add(lblInstall);

		lblHostName = new JLabel("MYSQL HOST NAME*");
		lblHostName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblHostName.setForeground(new Color(0, 0, 102));
		lblHostName.setBounds(495, 140, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblHostName);

		lblUsername = new JLabel("MYSQL USERNAME*");
		lblUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblUsername.setForeground(new Color(0, 0, 102));
		lblUsername.setBounds(495, 200, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblUsername);

		lblPassword = new JLabel("MYSQL PASSWORD*");
		lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblPassword.setForeground(new Color(0, 0, 102));
		lblPassword.setBounds(495, 260, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblPassword);

		lblDBLPLoc = new JLabel("DBLP XML FILE LOCATION");
		lblDBLPLoc.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblDBLPLoc.setForeground(new Color(0, 0, 102));
		lblDBLPLoc.setBounds(495, 320, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblDBLPLoc);

		lblCommitteeFolderPath = new JLabel("COMMITTEE FOLDER PATH");
		lblCommitteeFolderPath.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblCommitteeFolderPath.setForeground(new Color(0, 0, 102));
		lblCommitteeFolderPath.setBounds(495, 380, LABEL_WIDTH, LABEL_HEIGHT);
		frame.getContentPane().add(lblCommitteeFolderPath);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		lblError.setForeground(new Color(255, 0, 51));
		lblError.setBounds(495, 630, 360, 40);
		frame.getContentPane().add(lblError);

		btnInstall = new JButton("INSTALL & START APPLICATION");
		btnInstall.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnInstall.setBackground(new Color(255, 255, 255));
		btnInstall.setForeground(new Color(0, 0, 102));
		btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String newUserName = ftfUsername.getText();
				String newPassword = String.valueOf(ftfPassword.getPassword());
				String ipAddress = ftfHostName.getText();
				String dblpFileLoc = ftfDBLPLoc.getText();
				String committeeFolderLoc = ftfCommitteeFolderPath.getText();

				Boolean isValidNewUserName = Validator.isNonEmptyString(newUserName);
				Boolean isValidNewPassword = Validator.isNonEmptyString(newPassword); 
				Boolean isValidIpAddress = Validator.isNonEmptyString(ipAddress);
				Boolean isValidDblpFileLoc = Validator.isNonEmptyString(dblpFileLoc);
				Boolean isValidCommitteeFolderLoc = Validator.isNonEmptyString(committeeFolderLoc);


				if(isValidNewUserName && isValidNewPassword && isValidIpAddress && isValidDblpFileLoc &&
						isValidCommitteeFolderLoc){

					lblLoading = new JLabel("DATA BEING PARSED AND INSERTED IN DATABASE"); 


					String conUrl = "jdbc:mysql://" + ipAddress +":3306/dblp?createDatabaseIfNotExist=true";

					Database.DB_CONNECTION = conUrl;
					Database.DB_USER = newUserName;
					Database.DB_PASSWORD = newPassword;

					BackEnd.dblpXmlFileUri = dblpFileLoc;
					BackEnd.committeFolder = new File(committeeFolderLoc);

					ResponseMessage rm = HibernateUtil.buildSessionFactory(newUserName, newPassword, ipAddress);

					HibernateUtil.getSessionFactory().openSession();

					if(rm.isSuccess()){
						LoginPage lp = new LoginPage();

						JFrame loginPageFrame = lp.getFrame();

						if(loginPageFrame != null){
							loginPageFrame.setVisible(true);
							getFrame().setVisible(false);
						}
					}
					else{
						JOptionPane.showMessageDialog(getFrame(), rm.getMessage());
					}
				}

				else{
					changeLabels(isValidNewUserName, isValidNewPassword, isValidIpAddress, isValidDblpFileLoc, isValidCommitteeFolderLoc);
				}	
			}
		});
		btnInstall.setVerticalTextPosition(AbstractButton.CENTER);
		btnInstall.setHorizontalTextPosition(AbstractButton.CENTER);
		btnInstall.setBounds(495, 515, 360, 40);
		frame.getContentPane().add(btnInstall);

		btnSkip = new JButton("START APPLICATION (without install)");
		btnSkip.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnSkip.setBackground(new Color(255, 255, 255));
		btnSkip.setForeground(new Color(0, 0, 102));
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String newUserName = ftfUsername.getText();
				String newPassword = String.valueOf(ftfPassword.getPassword());
				String ipAddress = ftfHostName.getText();

				Boolean isValidNewUserName = Validator.isNonEmptyString(newUserName);
				Boolean isValidNewPassword = Validator.isNonEmptyString(newPassword); 
				Boolean isValidIpAddress = Validator.isNonEmptyString(ipAddress);

				if(isValidNewUserName && isValidNewPassword && isValidIpAddress){

					lblLoading = new JLabel("LOADING DATA FROM DATABASE"); 

					String conUrl = "jdbc:mysql://" + ipAddress +":3306/dblp?createDatabaseIfNotExist=true";

					Database.DB_CONNECTION = conUrl;
					Database.DB_USER = newUserName;
					Database.DB_PASSWORD = newPassword;

					ResponseMessage rm = HibernateUtil.buildSessionFactory(newUserName, newPassword, ipAddress);

					HibernateUtil.getSessionFactory().openSession();

					if(rm.isSuccess()){
						LoginPage lp = new LoginPage();

						JFrame loginPageFrame = lp.getFrame();

						if(loginPageFrame != null){
							loginPageFrame.setVisible(true);
							getFrame().setVisible(false);
						}
					}
					else{
						JOptionPane.showMessageDialog(getFrame(), rm.getMessage());
					}
				}
				else{
					changeLabels(isValidNewUserName, isValidNewPassword, isValidIpAddress, true, true);
				}
			}
		});
		btnSkip.setVerticalTextPosition(AbstractButton.CENTER);
		btnSkip.setHorizontalTextPosition(AbstractButton.CENTER);
		btnSkip.setBounds(495, 570, 360, 40);
		frame.getContentPane().add(btnSkip);


	}

	private void changeLabels(Boolean isValidNewUserName, Boolean isValidNewPassword, Boolean isValidIpAddress , Boolean isValidDblpFileLoc, Boolean isValidCommitteeFolderLoc){

		if(isValidNewUserName){	
			lblUsername.setText("MYSQL USERNAME");
			lblUsername.setForeground(new Color(0, 0, 102));
		}
		else{
			lblUsername.setText("MYSQL USERNAME CAN'T BE EMPTY");
			lblUsername.setForeground(new Color(255, 0, 51));
		}

		if(isValidNewPassword){
			lblPassword.setText("MYSQL PASSWORD");
			lblPassword.setForeground(new Color(0, 0, 102));
		}
		else{
			lblPassword.setText("MYSQL PASSWORD CAN'T BE EMPTY");
			lblPassword.setForeground(new Color(255, 0, 51));
		}

		if(isValidIpAddress){
			lblHostName.setText("MYSQL HOST NAME");
			lblHostName.setForeground(new Color(0, 0, 102));
		}
		else{
			lblHostName.setText("MYSQL HOST NAME CAN'T BE EMPTY");
			lblHostName.setForeground(new Color(255, 0, 51));
		}

		if(isValidDblpFileLoc){
			lblDBLPLoc.setText("DBLP XML FILE LOCATION");
			lblDBLPLoc.setForeground(new Color(0, 0, 102));
		}
		else{
			lblDBLPLoc.setText("DBLP XML FILE LOCATION CAN'T BE EMPTY");
			lblDBLPLoc.setForeground(new Color(255, 0, 51));
		}

		if(isValidCommitteeFolderLoc){
			lblCommitteeFolderPath.setText("COMMITTEE FOLDER PATH");
			lblCommitteeFolderPath.setForeground(new Color(0, 0, 102));
		}
		else{
			lblCommitteeFolderPath.setText("COMMITTEE FOLDER PATH CAN'T BE EMPTY");
			lblCommitteeFolderPath.setForeground(new Color(255, 0, 51));
		}

		lblError.setText("");

	}
}
