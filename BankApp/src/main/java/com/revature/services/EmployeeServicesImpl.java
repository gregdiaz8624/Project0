package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Employee;
import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoImpl;
import com.revature.repositories.EmployeeRepo;
import com.revature.repositories.EmployeeRepoImpl;
import com.revature.repositories.TransactionRepo;
import com.revature.repositories.TransactionRepoImpl;
import com.revature.repositories.UserRepo;
import com.revature.repositories.UserRepoImpl;

public class EmployeeServicesImpl implements EmployeeServices {
	
	private EmployeeRepo ep = new EmployeeRepoImpl();
	private UserRepo up = new UserRepoImpl();
	private AccountRepo ap = new AccountRepoImpl();
	private TransactionRepo tp = new TransactionRepoImpl();
	public static boolean verifyAccountMenu;

	@Override
	public Employee login(Scanner scanner) {
		System.out.println("Please enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		return ep.getEmployee(username, password);
		
	}

	@Override
	public Transaction verifyTransaction(Integer id) {
		tp.updateTransaction(id);
		return (tp.getTransactionById(id));
	}

	@Override
	public List<Transaction> viewAllTransactions() {
		
		return tp.getAllTransactions();
	}

	@Override
	public List<User> getUsers() {
		return up.getUsers();
	}

	@Override
	public User viewUserAccount(Scanner scanner) {
		System.out.println("Please enter the id of the user: ");
		Integer id = Integer.valueOf(scanner.nextLine());
		return up.getUserById(id);
	}

	@Override
	public Account approveAccount(Integer id) {
		ap.appoveAccount(id);
		return ap.getAccountById(id);
	}

	@Override
	public Account denyAccount(Integer id) {
		ap.denyAccount(id);
		return ap.getAccountById(id);
	}
	
}