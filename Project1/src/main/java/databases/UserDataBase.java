package databases;

import java.util.ArrayList;

import model.AdminUser;
import model.Architect;
import model.User;

public class UserDataBase {

	private static ArrayList<User> users = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			users.add(AdminUser.getInstance());
			users.add(new Architect("marko.gavrilovic@gmail.com", "123", "markogavrilovic"));
			users.add(new Architect("stef.adamovic@gmail.com", "321", "stefanadamovic"));
		}
	};

	public static ArrayList<User> getUsers() {
		return users;
	}

}
