package com.revature.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.dao.OfferDAOPostgres;
import com.revature.dao.PaymentDAOPostgres;
import com.revature.dao.carDAOPostgres;
import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.pojo.Payment;
import com.revature.pojo.User;
import com.revature.service.EmployeeLoginService;
import com.revature.util.LoggerUtil;

public class CustomerLoginService {
	
	private static LoggerUtil log = new LoggerUtil();
	
	private static Scanner scan = new Scanner(System.in);
	
	static carDAOPostgres cdp = new carDAOPostgres();
	
	static OfferDAOPostgres odp = new OfferDAOPostgres();
	
	static PaymentDAOPostgres pdp = new PaymentDAOPostgres();
	
	static String car;
	
	static int offer;
	
	public static void start() {
		
		String option = "";
		do {
			
			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("[0] Log out");
			System.out.println("[1] View cars");
			System.out.println("[2] Add offer");
			System.out.println("[3] View payments");
			System.out.println("[4] View owned cars");
			
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
			viewCars();
			break;
		case "2":
			System.out.println("Car: ");
			car = scan.nextLine();
			System.out.println("Offer: ");
			offer = Integer.parseInt(scan.nextLine());
			addOffer(car, offer);
			break;
		case "3":
			viewPayments();
			break;
		case "4":
			viewOwnedCars();
			break;
		}
	}

	public static void viewCars() {
		List<Car> cars = new ArrayList<>();
		cars = cdp.viewCars();
		System.out.println(cars);
	}
	
	public static void viewOwnedCars() {
		String username = Customer.getUsername();
		List<Car> carList = cdp.viewOwnedCars(username);
		System.out.println(carList);
	}
	
	public static void addOffer(String car, int offer) {
		odp.addOffer(car, offer);
		log.info("Added offer");
	}
	
	public static void viewPayments() {
		List<Payment> payments = new ArrayList<>();
		payments = pdp.viewPayment();
		System.out.println(payments);
	}
	

}