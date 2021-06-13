package com.revature.services;

import java.util.List;


import java.util.Scanner;

import com.revature.models.Account;


public interface AccountServices {
	
	void createAcc(Scanner scanner, Integer userId);
	
	Account viewAccount(Scanner scanner, Integer userId);
	
	Double viewBalance(Integer id, String type);
	List<Account> observeAccs(Integer id);
}
