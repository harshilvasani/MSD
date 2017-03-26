package validator.utils;

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
	
	public static void main(String[] args) {
		String s = "1234567890";
		System.out.println(isValidN(s));
		String pass = "123458Z";
		System.out.println(isValidPassword(pass));
	}
}
