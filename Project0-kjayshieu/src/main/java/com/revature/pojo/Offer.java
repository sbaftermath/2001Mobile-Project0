package com.revature.pojo;

public class Offer {
	
	private int amount;
	
	private int carID;
	
	private int userID;
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "Offer [amount=" + amount + ", carID=" + carID + ", userID=" + userID + "]";
	}

	public Offer(int amount, int carID, int userID) {
		super();
		this.amount = amount;
		this.carID = carID;
		this.userID = userID;
	}

}
