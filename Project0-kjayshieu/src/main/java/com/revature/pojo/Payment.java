package com.revature.pojo;

import java.io.Serializable;

public class Payment implements Serializable {

	public int payment;
	public int monthlyPayment;

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public int getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(int monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public void calculateMonthlyPayment() {
		this.setMonthlyPayment(this.getPayment() / 24);
	}
	
	
}
