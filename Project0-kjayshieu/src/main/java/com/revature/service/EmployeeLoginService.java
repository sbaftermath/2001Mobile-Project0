package com.revature.service;

import com.revature.pojo.User;
import com.revature.util.LoggerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.pojo.SystemCars;

public class EmployeeLoginService extends UserLoginService{
	
	private static LoggerUtil log = new LoggerUtil();
	
	public String[] cars = new String[10];
	
	public int numberOfCars = 0;
	
	public static boolean accept = false;
	
	public static Map<String, Integer> acceptedOffer = new HashMap<String, Integer>();
	
	public SystemCars SC = new SystemCars();
	
	public static Map<String, List<Integer>> Offers = new HashMap<String, List<Integer>>();
	
	@Override
	public boolean authenticateUser(User user) {
		return true;
	}
	
	@Override 
	public boolean authenticateUserAsEmployee(User user) {
		return true;
	}
	
	
	
	public Map<String, Integer> getAcceptedOffer() {
		return acceptedOffer;
	}



	public void setAcceptedOffer(Map<String, Integer> acceptedOffer) {
		this.acceptedOffer = acceptedOffer;
	}



	public void addCar(String string) {
		SystemCars.addCars(string);
		log.info(string + " has been added to lot");
	}
	
	public void removeCar(String string) {
		for (int i = 0; i < cars.length; i ++) {
			ArrayList<String> cars = SystemCars.getCars();
			if (cars.contains(string)) {
				cars.remove(string);
				log.info(string + " has been removed from lot");
			}
		}
	}
	
	public Map<String, List<Integer>> viewOffers(String string) {
		Map<String, List<Integer>> Offers = CustomerLoginService.getCarOffers();
		return Offers;
	}
	
	public void acceptOffer(String string, int value) {
		List<Integer> values = new ArrayList<Integer>();
		//Map<String, List<Integer>> Offers = CustomerLoginService.getCarOffers();
		Offers.putAll(CustomerLoginService.getCarOffers());

		//System.out.println(Offers.containsKey(string));
		//System.out.println(Offers.get(string));
		
		if (Offers.containsKey(string) == true) {
			values = Offers.get(string);
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i) == value) {
					Map<String, Integer> acceptoffer = new HashMap<String, Integer>();
					acceptoffer.put(string, value);
					setAcceptedOffer(acceptoffer);
					System.out.println(acceptedOffer);
					//System.out.println(acceptedOffer.get(string));
					//need to add to customer car list
					log.info("offer has been accepted");
					log.info("car added to owned list");
					SC.rejectAll(string);
				}
				else {
					System.out.println("Offer invalid");
				}
			}
		}
		else {
			System.out.println("Wrong car");
		}
	}
	
	public void rejectOffer(String string, int value) {
		Map<String, List<Integer>> Offers = CustomerLoginService.viewOffers();
		Offers.remove(string,value);
		log.info("Offer of: " + value + "removed from car:" + string);
	}
	
	public void viewPayments() {
		Map<String, Integer> offered = new HashMap<String, Integer>();
		int offer = 0;
		offered.putAll(getAcceptedOffer());
		System.out.println(offered.values());
	}

}
