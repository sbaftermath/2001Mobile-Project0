package com.revature.pojo;

public class Car{

	public String car;
	public int userID;
	public int carID;
	//public String model;
	//public String make;
	
	/*public String getModel() {
		return model;
	}
	public void setModel(String car) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
*/
	
	public void setCar(String car) {
		this.car = car;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCars() {
		return car;
	}


	public Car(String car, int userID, int carID) {
		super();
		this.car = car;
		this.userID = userID;
		this.carID = carID;
	}

	@Override
	public String toString() {
		return "Car [car=" + car + ", userID=" + userID + ", carID=" + carID + "]";
	}

	
}
