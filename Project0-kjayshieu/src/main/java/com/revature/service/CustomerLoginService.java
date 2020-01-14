package com.revature.service;

import com.revature.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.pojo.SystemCars;
import com.revature.service.EmployeeLoginService;
import com.revature.util.LoggerUtil;

public class CustomerLoginService extends UserLoginService {
	
	private static LoggerUtil log = new LoggerUtil();
	
	//private Map<String, List<Integer>> carOffers = new HashMap<String, List<Integer>>();
	private static Map<String, List<Integer>> carOffers = new HashMap<String, List<Integer>>();
	
	public static List<Integer> offers = new ArrayList<Integer>();
	
	public boolean own = false;
	
	public Map<String, Integer> Payment = new HashMap<String, Integer>();
	
	public EmployeeLoginService ELS = new EmployeeLoginService();
	
	public SystemCars SC = new SystemCars();

	@Override
	public boolean authenticateUser(User user) {
		return true;
	}
	
	public void setCarOffers(Map<String, List<Integer>> carOffers) {
		this.carOffers = carOffers;
	}
	
	public static Map<String, List<Integer>> getCarOffers(){
		return carOffers;
	}
	

	public void makeOffer(String string, int value) {
		offers.add(value);
		Map<String, List<Integer>> cO = getCarOffers();
		cO.put(string, offers);
		setCarOffers(cO);
		Map<String, List<Integer>> c1 = getCarOffers();
		System.out.println(c1);
		log.info("offer was made");
	}
	

	public void viewCarLot() {
		List<String> cars = SystemCars.getCars();
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}
	}

	public void viewMyCars() {
		Map<String, Integer> myCar = new HashMap<String, Integer>();
		myCar.putAll(ELS.getAcceptedOffer());
		System.out.println(myCar.keySet());
	}

	public void viewPayment(String string) {
		Map<String, Integer> offered = new HashMap<String, Integer>();
		int offer = 0;
		offered.putAll(ELS.getAcceptedOffer());
		System.out.println(offered);
		if (ELS.getAcceptedOffer().containsKey(string) == true) {
			offer = ELS.getAcceptedOffer().get(string);
			System.out.println("24 Payments of:" + SC.calculatePayment(offer));
		}
		else {
			System.out.println("You do not own this car");
		}
	}

	public static Map<String, List<Integer>> viewOffers() {
		return carOffers;
	}

}
