package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.interfaces.User;

public class Employee implements User, Serializable{
	
	public static ArrayList<String> cars = new ArrayList<String>();
	public static int carsCount = 0;
	public String username;
	public String password;
	

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
	public void acceptOffer() {
		
	}
	
	public void rejectOffer() {
		
	}
	
	public void addCar(String car) {
		cars.add(car);
		carsCount ++;
		//log car is added
	}
	
	public void removeCar(String string) {
		for (int i = 0; i < cars.size(); i ++) {
			ArrayList<String> cars = SystemCars.getCars();
			if (cars.contains(string)) {
				cars.remove(string);
				//log car is removed
			}
		}
	}
	
	public void viewPayments() {
		
	}

}
