package validators;

public class PasswordValidator {

	public static boolean checkPassword(String password) {
		if (password == null)
			return false;
		if (password.isEmpty())
			return false;
		return true;
	}

}
