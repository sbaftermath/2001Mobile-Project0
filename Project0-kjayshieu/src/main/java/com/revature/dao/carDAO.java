package com.revature.dao;

import java.util.List;

import com.revature.pojo.Car;

public interface carDAO {

	public void createCar(String car);
	
	public void removeCar(String car);
	
	public List<Car> viewCars();
	
	public List<Car> viewOwnedCars(String username);
}
