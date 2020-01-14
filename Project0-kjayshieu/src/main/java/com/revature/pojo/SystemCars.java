package com.revature.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.revature.service.CustomerLoginService;
import com.revature.util.LoggerUtil;

public class SystemCars {
	

	
	private static LoggerUtil log = new LoggerUtil();
	
	public static ArrayList<String> cars = new ArrayList<String>();
	
	public static int carsCount = 0;
	
	static int payment = 0;
	
	public static ArrayList<String> getCars() {
		return cars;
	}

	public static void addCars(String car) {
		cars.add(car);
		carsCount ++;
		log.info(car + " has been added");
	}
	
	public static void removeCar(String car) {
		for (int i = 0; i < carsCount; i ++) {
			if (cars.contains(car) == true) {
				cars.remove(car);
				carsCount--;
			}
		}
	}
	
	public void rejectAll(String string) {
		CustomerLoginService CLS = new CustomerLoginService();
		Map<String, List<Integer>> Offers = CLS.viewOffers();
		Offers.remove(string);
		removeCar(string);
		//log offers removed
	}
	
	public static int calculatePayment(int value) {
		payment = value / 24;
		return payment;
	}
}

