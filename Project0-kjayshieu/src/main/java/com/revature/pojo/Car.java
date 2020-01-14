package com.revature.pojo;

import java.io.Serializable;

import com.revature.dao.carDAOSerialization;

public class Car implements Serializable {

	public String car;
	public String make;
	public String iD;
	
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String get() {
		return iD;
	}
	public void set(String iD) {
		 this.iD = iD;
	}

	public void createCar(Car car) {
		carDAOSerialization CDS = new carDAOSerialization();
		CDS.createCar(car);
	}
	
	public void getCars() {
		carDAOSerialization CDS = new carDAOSerialization();
		CDS.readCar(car);
	}
	@Override
	public String toString() {
		return "Car [car=" + car + ", make=" + make + ", iD=" + iD + "]";
	}
	public Car(String car, String make, String iD) {
		super();
		this.car = car;
		this.make = make;
		this.iD = iD;
	}
	
	
}
