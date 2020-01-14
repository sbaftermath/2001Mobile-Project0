package com.revature.dao;

import com.revature.pojo.Car;

public interface carDAO {

	void createCar(Car car);
	
	Car readCar(String iD);
}
