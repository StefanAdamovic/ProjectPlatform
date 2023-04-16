package validators;


public class Validator {

	public static boolean checkUserName(String userName) {
		if (userName == null || userName.isEmpty())
			return false;
		return true;
	}
	
	public static boolean checkName(String name) {
		if (name == null || name.isEmpty())
			return false;
		return true;
	}
	
	public static boolean checkPassword(String password) {
		if (password == null || password.isEmpty())
			return false;
		return true;
	}
	
	public static boolean checkPasswordRepeat(String passwordRepeat) {
		if (passwordRepeat == null || passwordRepeat.isEmpty())
			return false;
		return true;
	}

	public static boolean checkEmail(String email) {
		if( email == null || email.isEmpty() ) 
			return false;
		return true;
	}
	
	
}

