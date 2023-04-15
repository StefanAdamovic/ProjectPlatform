package validators;

public class UserNameValidator {

	public static boolean checkUserName(String userName) {
		if (userName == null)
			return false;
		if (userName.isEmpty())
			return false;
		return true;
	}

}
