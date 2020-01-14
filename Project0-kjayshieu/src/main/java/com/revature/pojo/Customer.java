package com.revature.pojo;

import java.io.Serializable;

import com.revature.interfaces.User;

public class Customer implements User, Serializable{
	
	public String username;
	public String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	public void addOffer(int value, String car){
		Offer offer = new Offer();
		offer.setAmount(value);
		offer.setID(car);
		offer.createOffer();
	}
	
	public void viewPayment() {
		
	}
	
	public void viewMyCars() {
		
	}

}
