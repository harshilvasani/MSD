package frontend;
import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;

public class Interfacing_for_Update {
	private String fullName;
	private String emailID;
	private String username;
	private char[] password;
	private char[] verfiyPassword;
	private String phoneNumber;
	public Interfacing_for_Update(String fullName, String email,
			String username, char[] password, String phoneNumber){
		this.fullName = fullName;
		this.emailID = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public Boolean sendToApp(){
		App app = new App();
		resources.person.User user = new resources.person.User();
		user.setFulName(fullName);
		user.setEmailId(emailID);
		user.setUsername(username);
		user.setPassword(password.toString());
		user.setPhoneNumber(phoneNumber);
		ResponseMessage rm = app.updateProfile(user);
		return rm.isSuccess();
	}

}
