package com.revature.services;

import java.util.List;


import java.util.Scanner;
import com.revature.models.Account;
import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoImpl;

public class AccountServicesImpl implements AccountServices{
	
	private AccountRepo accountrepo = new AccountRepoImpl();
//

	@Override
	public void createAcc(Scanner scanner, Integer userId) {

		Account newAccount = new Account();
		newAccount.setStatus("pending");
		System.out.println("What would you like to name this account?");
		newAccount.setType(scanner.nextLine());
			
			
			System.out.println("Please enter how much you would like to store in your account: ");
			//make sure the balance isn't negative
			Double balance = new Double(scanner.nextLine());
			if( balance > 0) {
				newAccount.setBalance(balance);
				accountrepo.addAccount(userId, newAccount);
				
				System.out.println("The account is now pending \n");
			}else {
				System.out.println("Cannot store negative balance in your account.\n"
						+ "Account application canceled.");
			}
		}

	

	@Override
	public Double viewBalance(Integer id, String type) {
		return accountrepo.getBalance(id, type);
	}

	@Override
	public List<Account> observeAccs(Integer id) {
		return accountrepo.getAccountsByUser(id);
	}

	@Override
	public Account viewAccount(Scanner scanner, Integer userId) {
		
		
		
		
		return null;
	}


}
