package com.revature.driver;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.revature.pojo.User;
import com.revature.service.CustomerLoginService;
import com.revature.service.EmployeeLoginService;
import com.revature.service.UserLoginService;
import com.revature.util.LoggerUtil;

public class LoginDriver {

	private static LoggerUtil log = new LoggerUtil();

	private static UserLoginService uls = new UserLoginService();

	private static EmployeeLoginService els = new EmployeeLoginService();

	private static CustomerLoginService cls = new CustomerLoginService();

	private static Scanner scan = new Scanner(System.in);

	private static int access = 0;

	public static void main(String[] args) {

		String option = "";
		BasicConfigurator.configure();

		do {
			System.out.println("What would you like to do?");
			System.out.println("[1] Register User");
			System.out.println("[2] Login");
			System.out.println("[3] Exit");
			System.out.println("[4] Customer features");
			System.out.println("[5] Employee features");
			System.out.println("[6] View cars (Customer)");
			System.out.println("[7] Make offer (Customer)");
			System.out.println("[8] View owned cars (Customer)");
			System.out.println("[9] View payments (Customer)");
			System.out.println("[10] Accept offer (Employee)");
			System.out.println("[11] Reject offer (Employee)");
			System.out.println("[12] Add car (Employee)");
			System.out.println("[13] Remove car (Employee)");
			System.out.println("[14] View all payments (Employee)");
			System.out.println("");

			option = scan.nextLine();
			performUserAction(option);
		} while (!"3".equals(option));

	}

	private static void performUserAction(String option) {

		switch (option) {
		case "1":
			User user = getUserInfo();
			uls.registerUser(user.getUsername(), user.getPassword());
			break;
		case "2":
			if (((UserLoginService) uls).authenticateUser(getUserInfo())) {
				System.out.println("success");
			} else {
				System.out.println("failure");
			}
			break;
		case "3":
			System.out.println("goodbye");
			break;
		case "4":
			cls = new CustomerLoginService();
			System.out.println("You are now a customer");
			access = 1;
			log.info("Customer Logged in");
			break;
		case "5":
			els = new EmployeeLoginService();
			System.out.println("You are now an Employee");
			access = 2;
			log.info("Employeee logged in");
			break;
		case "6":
			if (access > 0) {
				cls.viewCarLot();
			} else {
				System.out.println("You are not a customer");
			}
			break;
		case "7":
			if (access > 0) {
				System.out.println("Car: ");
				String car = scan.nextLine();
				System.out.println("Offer: ");
				int offer = Integer.parseInt(scan.nextLine());
				cls.makeOffer(car, offer);
			} else {
				System.out.println("You are not a customer");
			}
			break;
		case "8":
			if (access > 0) {
				cls.viewMyCars();
			} else {
				System.out.println("You are not a customer");
			}
			break;
		case "9":
			if (access > 0) {
				System.out.println("Car: ");
				String car = scan.nextLine();
				cls.viewPayment(car);
			} else {
				System.out.println("You are not a customer");
			}
			break;
		case "10":
			if (access == 2) {
				System.out.println("Car: ");
				String car = scan.nextLine();
				System.out.println("Offer: ");
				int offer = Integer.parseInt(scan.nextLine());
				els.acceptOffer(car, offer);
			} else {
				System.out.println("You are not an Employee");
			}
			break;
		case "11":
			if (access == 2) {
				System.out.println("Car: ");
				String car = scan.nextLine();
				System.out.println("Offer: ");
				int offer = Integer.parseInt(scan.nextLine());
				els.rejectOffer(car, offer);
			} else {
				System.out.println("You are not an Employee");
			}
			break;
		case "12":
			if (access == 2) {
				System.out.println("Car: ");
				String car = scan.nextLine();
				els.addCar(car);
				log.info(car + " added to lot");
			} else {
				System.out.println("You are not an Employee");
			}
			break;
		case "13":
			if (access == 2) {
				System.out.println("Car: ");
				String car = scan.nextLine();
				els.removeCar(car);
				log.info(car + " removed from lot");
			} else {
				System.out.println("You are not an Employee");
			}
			break;
		case "14":
			if (access == 2) {
				els.viewPayments();
			} else {
				System.out.println("You are not an Employee");
			}
			break;
		default:
			System.out.println("did not understand input");
			break;

		}
	}

	private static User getUserInfo() {
		User user = new User();
		System.out.println("Enter username:");
		user.setUsername(scan.nextLine());
		System.out.println("Enter password");
		user.setPassword(scan.nextLine());
		return user;
	}

}
