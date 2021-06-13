package com.revature.services;

import java.util.List;


import java.util.Scanner;

import com.revature.models.Transaction;


public interface TransactionServices {

	Transaction viewTransaction (Scanner scanner);
	List<Transaction> viewCustomerTransactions (Integer i);
	void deposit(Scanner scanner, Integer id);
	void withdraw(Scanner scanner, Integer id);
	void transfer(Scanner scanner, Integer id);
}
