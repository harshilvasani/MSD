package frontend;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String fullName;
	private String emailID;
	private String username;
	private char[] password;
	private char[] verifyPassword;
	private String phoneNumber;
	public User(){
	}
	
	// setter getters for all the above fields
	public void setFullName(String fullName){
		this.fullName = fullName;
	}
	public void setEmailID(String email){
		this.emailID = email;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(char[] password){
		this.password = password;
	}
	public void setVerifyPassword(char[] verifyPassword){
		this.verifyPassword = verifyPassword;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public String getFullName(){
		return this.fullName;
	}
	public String getEmailID(){
		return this.emailID;
	}
	public String getUsername(){
		return this.username;
	}
	public char[] getPassword(){
		return this.password;
	}
	public char[] getVerifyPassword(){
		return this.verifyPassword;
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	// syntax checkers for the all the above fields
	public Boolean checkFullName(){
		char[] temp = this.fullName.toCharArray();
		int len = temp.length;
		if(len<1) return false;
		if(len==1 && this.fullName.charAt(0)==' ') return false;
		int spaceCount = 0;
		Boolean flag = true;
		for(int i=0;i<len;i++){
			if(temp[i]==' ') spaceCount++;
			if(temp[i]==' ' || Character.isLetter(temp[i])) continue;
			else {
				flag = false;
				break;
			}
		}
		if(spaceCount>1) flag=false;
		return flag;
	}
	public Boolean checkEmailID(){
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(this.emailID);
        if (matcher.matches())	return true;
        else return false;
	}
	public Boolean checkUsername(){
		Boolean flag = true;
		char[] temp = this.username.toCharArray();
		int len = temp.length;
		if(len<1) return false;
		for(int i=0;i<len;i++){
			if(Character.isLetterOrDigit(temp[i]) || temp[i]=='_') continue;
			else{
				flag = false;
				break;
			}
		}
		return flag;
	}
	public Boolean checkPassword(){
		Boolean letter = false;
		Boolean digit = false;
		int len = this.password.length;
		if(len<8) return false;
		for(int i=0;i<len;i++){
			if(Character.isLetter(this.password[i])) letter = true;
			if(Character.isDigit(this.password[i])) digit = true;
		}
		return (letter && digit);
	}
	public Boolean checkVerifyPassword(){
		Boolean flag = true;
		if(this.password.length!=this.verifyPassword.length) return false;
		int len = this.password.length;
		for(int i=0;i<len;i++){
			if(this.password[i]!=this.verifyPassword[i]){
				flag = false;
				break;
			}
		}
		return flag;
	}
	public Boolean checkPhoneNumber(){
		Boolean flag = true;
		char[] temp = this.phoneNumber.toCharArray();
		int len = temp.length; 
		if(len!=10) return false;
		for(int i=0;i<len;i++){
			if(Character.isDigit(temp[i])==false){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	// information passers for register update and login
	public Boolean sendToRegisterInterfacing(){
		
		Interfacing_for_Register register = new Interfacing_for_Register(
				this.fullName, this.emailID, this.username, this.password, this.phoneNumber);
		
		return register.sendToApp();
		
	}
	public Boolean sendToUpdateInterfacing(){
		
		Interfacing_for_Update update = new Interfacing_for_Update(
				this.fullName, this.emailID, this.username, this.password, this.phoneNumber);
		
		return update.sendToApp();
		
	}
	public Boolean sendToLoginInterfacing(){
		
		Interfacing_for_Login login = new Interfacing_for_Login(this.username, this.password);
		
		return login.sendToApp();
		
	}
}
