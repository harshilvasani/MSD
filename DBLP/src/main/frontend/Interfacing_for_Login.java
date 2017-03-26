package frontend;
import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;

public class Interfacing_for_Login {
	private String username;
	private char[] password;
	public Interfacing_for_Login(String username, char[] password){
		this.username = username;
		this.password = password;
	}
	public Boolean sendToApp(){
		App app = new App();
		ResponseMessage rm = app.login(username, password.toString());
		return rm.isSuccess();
	}
}
