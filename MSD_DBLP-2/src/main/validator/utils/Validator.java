package validator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isValidN(String s) {
		if (s == null || s.length() == 0)
			return false;
		
		for (char c: s.toCharArray())
		{
			if (c < 48 || c > 57)
				return false;
		}

		return true;
	}

	public static boolean isValidYear(String s) {
		if (s == null || s.length() != 4)
			return false;

		for (char c: s.toCharArray())
		{
			if (c < 48 || c > 57)
				return false;
		}

		return true;
	}

	public static boolean isNonEmptyString(String s) {
		return !(s == null || s.length() == 0);
	}

	public static boolean isValidPassword(String s) {
		if (s == null || s.length() < 8) {
			return false;
		}
		boolean validLetter = false;
		boolean validNum = false;
		for (char c: s.toCharArray())
		{
			if (c >= 48 && c <= 57)
				validNum = true;
			else if ((c >= 97 && c <= 122) ||
					(c >= 65 && c <=90))
				validLetter = true;
		}
		return validNum && validLetter;
	}

	public static Boolean isValidUsername(String username){
		Boolean flag = true;

		char[] temp = username.toCharArray();
		int len = temp.length;

		if(len<1) 
			return false;

		for(int i=0;i<len;i++){
			if(Character.isLetterOrDigit(temp[i]) || temp[i]=='_') continue;
			else{
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static Boolean isValidPhoneNumber(String phoneNumber){
		Boolean flag = true;
		char[] temp = phoneNumber.toCharArray();
		int len = temp.length; 
		if(len!=10) return false;

		for(int i=0; i<len; i++){

			if(Character.isDigit(temp[i]) == false){
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static Boolean arebothPasswordSame(String password, String verifyPassword){
		Boolean flag = true;

		if(password.length() != verifyPassword.length())
			return false;

		char[] pwd = password.toCharArray();
		char[] verifyPwd = verifyPassword.toCharArray();

		int len = password.length();

		for(int i=0; i<len; i++){

			if(pwd[i] != verifyPwd[i]){
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static Boolean isValidEmailId(String emailId){

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; 

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);

		return matcher.matches();
	}

	public static Boolean isValidFullName(String fullName){
		char[] temp = fullName.toCharArray();
		int len = temp.length;

		if(len < 1)
			return false;
		if(len == 1 && fullName.charAt(0) == ' ') 
			return false;

		int spaceCount = 0;
		Boolean flag = true;

		for(int i=0; i<len; i++){

			if(temp[i]==' ')
				spaceCount++;

			if(temp[i]==' ' || Character.isLetter(temp[i])) 
				continue;

			else {
				flag = false;
				break;
			}
		}
		if(spaceCount > 1) flag=false;
		return flag;
	}
}
