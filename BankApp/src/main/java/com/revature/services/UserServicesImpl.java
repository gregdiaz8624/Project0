package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.repositories.UserRepo;
import com.revature.repositories.UserRepoImpl;

public class UserServicesImpl implements UserServices{

	private UserRepo userrepo = new UserRepoImpl();
	
	@Override
	public User login(Scanner scanner) {
	
		System.out.println("Please enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		return userrepo.getUser(username, password);
	}

	@Override
	public void register(Scanner scanner) {

		User user = new User();
		System.out.println("Enter a username: ");
		user.setUsername(scanner.nextLine());
		System.out.println("Enter a password: ");
		user.setPassword(scanner.nextLine());
	
		System.out.println("You have inserted: ");
		System.out.println("Username: " + user.getUsername());
		System.out.println("Is this information correct? (y/n)");
		String input = scanner.nextLine();
			if("y".equalsIgnoreCase(input)) {
			
				userrepo.addUser(user);
				User newUser = userrepo.getUserNoAcc(user.getUsername(), user.getPassword());
		
				if (newUser.getId() != 0) {
					
				System.out.println("Account successfully created.");
				} 
				else {
				System.out.println("Account unsuccessfully created, please try again.");
				}
			} 
			else {
			System.out.println("Failed to create Username and Password.");
		}
	}

	

}