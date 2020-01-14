package com.revature.dao;

import com.revature.pojo.User;

public interface UserDAO {
	
	public void createUser(String username, String password);
	
	public User readUser(String username);

}
