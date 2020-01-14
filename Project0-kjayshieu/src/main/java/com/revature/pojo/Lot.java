package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Lot implements Serializable{
	ArrayList<Car> cars = new ArrayList<Car>();
	ArrayList<Offer> offers = new ArrayList<Offer>();
	ArrayList<Payment> payments = new ArrayList<Payment>();
}
