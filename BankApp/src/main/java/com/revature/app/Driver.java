package com.revature.app;

import java.util.Scanner;

import com.revature.logging.AppLogger;
//import com.revature.models.Account;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.services.AccountServices;
import com.revature.services.AccountServicesImpl;
import com.revature.services.EmployeeServices;
import com.revature.services.EmployeeServicesImpl;
import com.revature.services.TransactionServices;
import com.revature.services.TransactionServicesImpl;
import com.revature.services.UserServices;
import com.revature.services.UserServicesImpl;

public class Driver {
	
	
	private static Scanner s = new Scanner(System.in);
	private static Integer loggedUserId = 0;
	public static User loggedUser;
	public static Integer accountId = 0;
	private static boolean mainMenu;
	private static Employee loggedEmployee;
	private static boolean userMenu;
	private static boolean employeeMenu;
	
	
	private static UserServices us = new UserServicesImpl();
	private static AccountServices as = new AccountServicesImpl();
	private static TransactionServices ts = new TransactionServicesImpl();
	private static EmployeeServices es = new EmployeeServicesImpl();

	public static void main(String[] args) {
		
		AppLogger.logger.info("Program started");
		
		System.out.println("Welcome to Gregory's Bank Application");
		mainMenu = true;
		while( mainMenu ) {
			System.out.println("Choose a command below:");
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3  Employee Portal");
			System.out.println("0. Quit");
			Integer input = Integer.valueOf(s.nextLine());

			switch (input) {
			case 1: { 
				mainMenu = false;
				login();
				break;
			}
			case 2: {
				mainMenu = false;
				register();
				break;
			}
			case 3: {
				mainMenu = false;
				loginEmployee();
				break;
			}
			case 0: {
				mainMenu = false;
				break;
			}
			default: {
				System.out.println("Please try again.");
				break;
			}
			}
			
		} 
		
		s.close();
	}
	
	public static void login() {
		loggedUser = us.login(s);
		if (loggedUser == null){
			System.out.println("Invalid login.\n");
			mainMenu = true;
		} else {
//			AppLogger.logger.info("Logged in as user " + u.getId());
			loggedUserId = loggedUser.getId();
			System.out.println("Successfully logged in. Welcome " + loggedUser.getUsername());
			userOption();
		}
		
	}
	
	public static void register() {
		us.register(s);
		mainMenu = true;
		
	}
	
	public static void userOption() {
		userMenu = true;
		while (userMenu) {
			System.out.println();
			System.out.println("Choose a command below:");
			System.out.println("1. Apply for new bank account");
			System.out.println("2. View accounts");
			System.out.println("3. Withdraw");
			System.out.println("4. Deposit");
			System.out.println("5. Transfer");
			System.out.println("0. Logout");
			Integer input = Integer.valueOf(s.nextLine());
			switch (input) {
			case 1: { // Apply for account
				as.createAcc(s, loggedUserId);
				break;
			}
			case 2: { // View balance of account
				if(as.observeAccs(loggedUserId).size() == 0 ) {
					System.out.println("You have no accounts!\n");
					
				}else {
					System.out.println(as.observeAccs(loggedUserId));
				}
				break;
			}
			case 3: { // Withdraw from an account
				ts.withdraw(s, loggedUserId);
				break;
			}
			case 4: { // Deposit into an account
				ts.deposit(s, loggedUserId);
				break;
			}
			case 5: { // Transfer between accounts
				ts.transfer(s, loggedUserId);
				break;
			}
			case 0: {

				System.out.println("Logged out");
				loggedUserId = 0;
				userMenu = false;
				mainMenu = true;
				break;
			}
			default: {
				System.out.println("Choice not recognized.");
				break;
			}
			}
		} 
	}
	
	private static void loginEmployee() {
		loggedEmployee = es.login(s);

		if (loggedEmployee == null) {
			System.out.println("Incorrect Login, please try again\n");
			mainMenu = true;
			AppLogger.logger.info("Logged in as an Employee");
			
		} else {
			System.out.println("Login successfull!");
			employeeOption();
		}
	}
	
	public static void employeeOption() {
		employeeMenu = true;
		
		while(employeeMenu) {
			System.out.println();
			System.out.println("Choose a command below: ");

			System.out.println("1. View a Customer's accounts");
			System.out.println("2. Approve pending account");
			System.out.println("3. Reject Pending account");
			System.out.println("4. View all transaction logs");
			System.out.println("0. Logout");
			Integer input = Integer.valueOf(s.nextLine());
			
			switch (input) {
			case 1: { // View a customer's accounts
//				System.out.println(es.getUsers());User viewUsers = es.viewUserAccount(s);
//				System.out.println(viewUsers);
				System.out.println(es.viewUserAccount(s));
				break;
			
			}
			case 2: { // Reject or Approve pending accounts

				System.out.println("Please enter the id of the Account you wish to approve: ");
				Integer aid = Integer.valueOf(s.nextLine());
				es.approveAccount(aid);
				System.out.println("Account Aproved");
	
			
				break;
			
			}
			case 3: { // View transaction logs
				System.out.println("Please enter the id of the Account you wish to deny: ");
				Integer aid = Integer.valueOf(s.nextLine());
				es.denyAccount(aid);
				System.out.println("Account Denied");

				break;
			}
			case 4: { // View transaction logs
				System.out.println(es.viewAllTransactions());
				break;
			}
			case 0: {
				System.out.println("Logged out");		
				employeeMenu = false;
				mainMenu = true;
				break;
			}
			default: {
				System.out.println("Choice not recognized.");
				break;
			}
			}
		} 
	}
	
}