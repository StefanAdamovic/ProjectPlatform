package model;

public class User {

	private static int numOfUsers = 0;

	private int id;
	private String email;
	private String password;
	private String userName;
	private String name;
	private JobTypes position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobTypes getPosition() {
		return position;
	}

	public void setPosition(JobTypes position) {
		this.position = position;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", userName=" + userName + ", name="
				+ name + ", position=" + position + "]";
	}

	public User(int id, String email, String password, String userName, String name, JobTypes position) {
		
		this.id = ++numOfUsers;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.name = name;
		this.position = position;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
