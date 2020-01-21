package com.revature.dao;

import java.util.List;

import com.revature.pojo.Payment;

public interface PaymentDAO {

	public void createPayment(String car, int offer);
	
	public List<Payment> viewPayment();
	
	public List<Payment> viewAllPayments();
}
