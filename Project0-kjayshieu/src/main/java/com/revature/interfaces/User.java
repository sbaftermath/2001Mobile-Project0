package com.revature.interfaces;

public interface User {
	
	public void setUsername(String username);
	
	public String getUsername();
	
	public void setPassword(String password);
	
	public String getPassword();
	
	public void login(String username, String password);

}
