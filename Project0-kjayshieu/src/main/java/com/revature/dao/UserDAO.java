package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDAO {
	
	public void createUser(String username, String password);
	
	public List<User> loginUser(String username, String password);
	
	public void setEmployee();
	
	public void setCustomer();

}
