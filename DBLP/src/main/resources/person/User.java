package resources.person;

public class User {
	
	private int id;
	private String username; 
	private String password;
	private String fulName;
	private String phoneNumber;
	private String emailId;

	public User(){
		
	}
	
	public User(int id, String username, String password, String fulName, String phoneNumber, String emailId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fulName = fulName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFulName() {
		return fulName;
	}
	public void setFulName(String fulName) {
		this.fulName = fulName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
