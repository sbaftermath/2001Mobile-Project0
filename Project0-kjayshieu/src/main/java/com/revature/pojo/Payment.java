package com.revature.pojo;

import java.io.Serializable;

public class Payment implements Serializable {

	private int payment;
	
	private int car_id;
	
	private int user_id;

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

	public Payment(int payment, int car_id, int user_id) {
		super();
		this.payment = payment;
		this.car_id = car_id;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Payment [payment=" + payment + ", car_id=" + car_id + ", user_id=" + user_id + "]";
	}


	
}
