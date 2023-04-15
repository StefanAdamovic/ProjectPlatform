package databases;

import java.util.ArrayList;
import java.util.Arrays;

import model.Project;

public class ProjectDataBase {

	// Simulacija baze projekata
	private static ArrayList<Project> projects = new ArrayList<Project>(Arrays.asList(
			new Project("Verona1", "Serbia", "Belgrad", "CTP"), new Project("Verona2", "Serbia", "Belgrad", "CTP"),
			new Project("Verona3", "Serbia", "Belgrad", "CTP"), new Project("Verona4", "Serbia", "Belgrad", "CTP"),
			new Project("Verona5", "Serbia", "Belgrad", "CTP"), new Project("Verona6", "Serbia", "Belgrad", "CTP"),
			new Project("Verona7", "Serbia", "Belgrad", "CTP")

	));

	// Provera da li projekat postoji

	public static boolean isExists(String name, String client) {
		for (Project project : projects) {
			if (project.getName().equalsIgnoreCase(name) && project.getClient().equalsIgnoreCase(client)) {
				return true;
			}
		}
		return false;
	}

	// Dodavanje korisnika u bazu korisnika
	public static void addProject(String name, String country, String city, String client) {
		projects.add(new Project(name, country, city, client));
	}

	// Dohvatanje baze korisnika
	public static ArrayList<Project> getProjects() {
		return projects;
	}

}
