package validators;

import java.util.regex.Pattern;

public class Validator {

	public static boolean checkUserName(String userName) {
		if (userName == null)
			return false;
		if (userName.isEmpty())
			return false;
		return true;
	}
	
	public static boolean checkPassword(String password) {
		if (password == null)
			return false;
		if (password.isEmpty())
			return false;
		return true;
	}

	// email validacija
	public static boolean checkEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if(Pattern.matches(regex, regex)) {
			return true;
		}
		return false;
	}
	
	
}
