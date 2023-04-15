package databases;

import java.util.ArrayList;
import java.util.Arrays;

import model.AdminUser;
import model.JobTypes;
import model.User;


public class UserDataBase {

	// Simulacija baze korisnika
	private static ArrayList<User> users = new ArrayList<User>(Arrays.asList(AdminUser.getInstance(),
			new User("marko.gavrilovic@gmail.com", "123", "markogavrilovic", "Marko", JobTypes.TEHNICIAN),
			new User("stef.adamovic@gmail.com", "321","stefanadamovic", "Stefan", JobTypes.ARCHITECT)));

	// Provera da li je korisnik registrovan
	// ne razumem zasto ne mogu da proverim ovom metodom uslov u servletu pa sam
	// morao da koristim stream() umesto ovoga
	public static boolean isRegistered(String username, String password) {
		for (User user : users) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	// Dodavanje korisnika u bazu korisnika
	public static void addUser(String email, String password, String username, String name, JobTypes position) {
		users.add(new User(email, password, username, name, position));
	}

	// Dohvatanje baze korisnika
	public static ArrayList<User> getUsers() {
		return users;
	}

}
