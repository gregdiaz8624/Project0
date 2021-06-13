package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Employee;
import com.revature.models.Transaction;
import com.revature.models.User;

public interface EmployeeServices {
	
	Employee login(Scanner scanner);
	
	Transaction verifyTransaction(Integer id);
	List<Transaction> viewAllTransactions();
	
	List<User> getUsers();
	User viewUserAccount(Scanner scanner);
	Account approveAccount(Integer id);
	Account denyAccount(Integer id);

}
