package com.revature.pojo;

public class User{

	private int id;
	
	private String username;
	
	private String password;
	
	private boolean isEmployee;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", isEmployee=" + isEmployee
				+ "]";
	}

	public User(int id, String username, String password, boolean isEmployee) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
	}


}
