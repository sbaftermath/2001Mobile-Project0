package com.revature.service;


import com.revature.dao.OfferDAOPostgres;
import com.revature.dao.PaymentDAOPostgres;
import com.revature.dao.carDAOPostgres;
import com.revature.pojo.Car;
import com.revature.pojo.Payment;
import com.revature.util.LoggerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class EmployeeLoginService{
	
	private static LoggerUtil log = new LoggerUtil();
	
	private static Scanner scan = new Scanner(System.in);
	
	public static carDAOPostgres cdp = new carDAOPostgres();
	
	public static PaymentDAOPostgres pdp = new PaymentDAOPostgres();
	
	public static OfferDAOPostgres odp = new OfferDAOPostgres();
	
	static String car = "";
	
	static int offer;
	
	public static void start() {
		String option = "";
		
		do {
			
			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("[0] Log out");
			System.out.println("[1] Add cars");
			System.out.println("[2] Remove car");
			System.out.println("[3] Accept offer");
			System.out.println("[4] Reject offer");
			System.out.println("[5] View all payments");
			System.out.println("[6] View cars");
			System.out.println("[7] View offers");
			System.out.println("");
			
			option = scan.nextLine();
			
			preformUserAction(option);
			
			
		}while(!"0".equals(option));
		
	}
	
	public static void preformUserAction(String option) {
		switch(option) {
		case "0":
			System.out.println("logged out");
			LoginService.Start();
			break;
		case "1":
			System.out.println("Car: ");
			car = scan.nextLine();
			addCar(car);
			break;
		case "2":
			System.out.println("Car: ");
			car = scan.nextLine();
			removeCar(car);
			break;
		case "3":
			System.out.println("Car: ");
			car = scan.nextLine();
			System.out.println("Offer: ");
			offer = Integer.parseInt(scan.nextLine());
			acceptOffer(car, offer);
			break;
		case "4":
			System.out.println("Car: ");
			car = scan.nextLine();
			System.out.println("Offer: ");
			offer = Integer.parseInt(scan.nextLine());
			rejectOffer(car, offer);
			break;
		case "5":
			viewAllPayments();
			break;
		case "6":
			viewCars();
			break;
		case "7":
			viewAllPayments();
			break;
		}
	}
	
	public static void addCar(String car) {
		cdp.createCar(car);
		log.info("added car to Lot");
	}
	
	public static void removeCar(String car) {
		cdp.removeCar(car);
		log.info("removed car from Lot");
	}
	
	public static void viewAllPayments() {
		List<Payment> Payments = pdp.viewAllPayments();
		System.out.println(Payments);
	}
	
	public static void acceptOffer(String car, int amount) {
		odp.acceptOffer(car, amount);
		log.info("Accepted offer");
	}
	
	public static void rejectOffer(String car, int amount) {
		odp.rejectOffer(car, amount);
		log.info("Rejected offer");
	}
	
	public static void viewCars(){
		List<Car> carList = cdp.viewCars();
		System.out.println(carList);
	}

}
