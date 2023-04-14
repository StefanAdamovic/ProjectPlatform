package model;

public abstract class User {

	private static int numOfUsers = 0;

	private int id;
	private String email;
	private String password;
	private String userName;

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
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", userName=" + userName + "]";
	}

	public User(String email, String password, String userName) {
		super();
		numOfUsers++;
		this.id = numOfUsers;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
