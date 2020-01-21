package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.UserDAOPostgres;
import com.revature.pojo.Customer;
import com.revature.pojo.Employee;
import com.revature.pojo.User;

public class LoginService {

	private static Scanner scan = new Scanner(System.in);

	static String username = "";

	static String password = "";

	static UserDAOPostgres udp = new UserDAOPostgres();

	public static void Start() {

		String option = "";
		
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.println("[0] Exit");
		System.out.println("[1] Register User");
		System.out.println("[2] Login");
		System.out.println("");

		option = scan.nextLine();

		preformUserAction(option);
	}

	private static void preformUserAction(String option) {
		// TODO Auto-generated method stub
		switch (option) {
		case "0":
			System.out.println("Goodbye");
			break;
		case "1":
			System.out.println("Username:");
			username = scan.nextLine();
			System.out.println("Password:");
			password = scan.nextLine();
			createUser(username, password);
			Start();
			break;
		case "2":
			System.out.println("Username:");
			username = scan.nextLine();
			System.out.println("Password:");
			password = scan.nextLine();
			loginUser(username, password);
		}

	}

	private static void createUser(String username, String password) {
		udp.createUser(username, password);
	}

	private static void loginUser(String username, String password) {
		List<User> userList = new ArrayList<>();
		userList = udp.loginUser(username, password);
		User user = userList.get(0);
		if (user.isEmployee() == false) {
			System.out.println("Login sucessful");
			Customer.setUsername(username);
			Customer.setPassword(password);
			CustomerLoginService.start();
		}
		if (user.isEmployee() == true) {
			System.out.println("Login sucessful");
			Employee.setUsername(username);
			Employee.setPassword(password);
			EmployeeLoginService.start();
		}
	}
}
