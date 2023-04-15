package model;

import java.util.ArrayList;

public class Project implements ITask, IUser {

	private static int numOfProject = 0;
	private int id;

	private String name;
	private String country;
	private String city;
	private String client;
	private Status status;

	private ArrayList<User> users;
	private ArrayList<Task> tasks;

	public Project(String name, String country, String city, String client) {
		super();
		this.id = ++numOfProject;
		this.name = name;
		this.country = country;
		this.city = city;
		this.client = client;
		users = new ArrayList<>();
		tasks = new ArrayList<>();
	}

	@Override
	public void addTask(Task task) {
		tasks.add(task);
	}

	@Override
	public void addUser(String email, String password, String username, String name, JobTypes position) {
		users.add(new User(email, password, username, name, position));
		
	}
	

	public String getCity() {
		return city;
	}

	public String getClient() {
		return client;
	}

	public String getCountry() {
		return country;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Status getStatus() {
		return status;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public void submitTask(Task task) {
		// TODO Auto-generated method stub

	}

	

}
