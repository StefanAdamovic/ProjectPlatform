package model;

public class AdminUser extends User {

	private static int count = 0;
	private static AdminUser admin;

	public static AdminUser getInstance() {
		if (count == 0) {
			count++;
			admin = new AdminUser("admin", "admin", "admin", "admin", JobTypes.PROJECT_MANAGER );
			return admin;
		} else {
			return admin;
		}
	}

	private AdminUser(String email, String password, String userName, String name, JobTypes position) {
		super(email, password, userName, name, position);
	}

	public void createUser(User x) {
		// TODO
	}

	public void deleteUser(User x) {
		// TODO
	}

	public void updateUser(User x) {
		// TODO
	}

}
