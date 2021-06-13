package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Transaction;

import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoImpl;
import com.revature.repositories.TransactionRepo;
import com.revature.repositories.TransactionRepoImpl;


public class TransactionServicesImpl implements TransactionServices{
	
	private TransactionRepo tr = new TransactionRepoImpl();
	private AccountRepo ar = new AccountRepoImpl();
	public static boolean transferMenu;


	@Override
	public Transaction viewTransaction(Scanner scanner) {
		System.out.println("Please enter the id of the transaction: ");
		Integer id = Integer.valueOf(scanner.nextLine());
		return tr.getTransactionById(id);
	}

	@Override
	public List<Transaction> viewCustomerTransactions(Integer i) {
		Integer id = i;
		return tr.getTransactions(id);
	}

	@Override
	public void deposit(Scanner scanner, Integer id) {
		List<Account> accounts = ar.getAccountsByUser(id);
		Integer chId = 0;
		Integer svId = 0;
		Double chBal = new Double("0") ;
		Double svBal = new Double("0") ;
		
		
		for ( Account acc : accounts) { 
		
			if(acc.getType().equals("checking") ) {
				chId = acc.getId();
				chBal = acc.getBalance();
			}
			
			else if(acc.getType().equals("saving") ) {
				svId = acc.getId();
				svBal = acc.getBalance();
			}
		
		}
		
		System.out.println("checking or saving?");
		String ans = scanner.nextLine();
		if (ans.equalsIgnoreCase("checking")) {
			System.out.println("Your current balance in checking is: " + chBal);
			System.out.println("How much would you like to deposit?");
			Double input = new Double(scanner.nextLine());
			

			// Checking to see if input is valid.
			if (input >= 0) {
				if (input.compareTo(chBal) != 0) {
					tr.addTransaction(input, "deposit", "pending");
	
					// math for withdraw
					chBal = chBal + input;
	
					// editing accounts in database
					ar.updateAccount(chId, chBal);
	
					// return confirmation
					System.out.println("Your current balance in checking is: " + chBal);
	//				System.out.println("Deposit is now filed and pending");
				} else {
					System.out.println("Invalid input, input cannot be less than or equal to 0");
				}
			} else {
				System.out.println("Invalid input, input cannot be less than or equal to 0");
			}
			

		} else if (ans.equalsIgnoreCase("saving")) {
			System.out.println("Your current balance in saving is: " + svBal);
			System.out.println("How much would you like to deposit?");
			Double input = new Double(scanner.nextLine());

			// Checking to see if input is valid.
			if (input >0 ) {
				if (input.compareTo(chBal) == -1 || input.compareTo(chBal) == 0) {
					tr.addTransaction(input, "deposit", "pending");
	
					// math for transfer
					svBal = svBal + input;
	
					// editing accounts in database
					ar.updateAccount(svId, svBal);
	
					// return confirmation
	//				System.out.println("Deposit is now filed and pending");
	
					System.out.println("Your current balance in saving is: " + svBal);
				} else {
					System.out.println("Invalid input, input cannot be less than or equal to 0");
				}
			} else {
				System.out.println("Invalid input, input cannot be less than or equal to 0");
			}
		}else {
			System.out.println("Invalid input, input cannot be less than or equal to 0");
		}
		
	}

	
	@Override
	public void withdraw(Scanner scanner, Integer id) {
		List<Account> accounts = ar.getAccountsByUser(id);
		Integer chId = 0;
		Integer svId = 0;
		Double chBal = new Double("0") ;
		Double svBal = new Double("0") ;
		
		
		for ( Account acc : accounts) { 
		
			if(acc.getType().equals("checking") ) {
				chId = acc.getId();
				chBal = acc.getBalance();
			}
			
			else if(acc.getType().equals("saving") ) {
				svId = acc.getId();
				svBal = acc.getBalance();
			}
		
		}
		
		System.out.println("checking or saving?");
		String ans = scanner.nextLine();
		
		if (ans.equalsIgnoreCase("checking")) {
			
			System.out.println("Your current balance in checking is: " + chBal);
			System.out.println("How much would you like to withdraw?");
			Double input = new Double(scanner.nextLine());
			

			// Checking to see if input is valid.
			if(input >= 0) {
				if (input.compareTo(chBal) == -1 || input.compareTo(chBal) == 0) {
					tr.addTransaction(input, "withdrawl", "pending");
	
					// math for withdraw
					chBal = chBal - input;
	
					// editing accounts in database
					ar.updateAccount(chId, chBal);
	
					// return confirmation
					System.out.println("Your current balance in checking is: " + chBal);
	//				System.out.println("Withdrawl is now filed and pending");
				} else {
					System.out.println("Invalid input, input cannot be greater than account balance");
				}
			}else {
				System.out.println("Invalid input, input cannot be less than or equal to 0");
				
			}
		} else if (ans.equalsIgnoreCase("saving")) {
			System.out.println("Your current balance in saving is: " + svBal);
			System.out.println("How much would you like to withdrawl?");
			Double input = new Double(scanner.nextLine());

			// Checking to see if input is valid.
			if(input >=0) {
				if (input.compareTo(chBal) == -1 || input.compareTo(chBal) == 0) {
					tr.addTransaction(input, "withdrawl", "pending");
	
					// math for transfer
					svBal = svBal - input;
	
					// editing accounts in database
					ar.updateAccount(svId, svBal);
	
					// return confirmation
					System.out.println("Your current balance in saving is: " + svBal);
	//				System.out.println("Withdrawl is now filed and pending");
	
				} else {
					System.out.println("Invalid input, input cannot be less than or equal to 0");
				}
			} else {
				System.out.println("Invalid input, input cannot be less than or equal to 0");
			}
		} else {
			System.out.println("Invalid input, input cannot be less than or equal to 0");

		}
			
	}

	@Override
	public void transfer(Scanner scanner, Integer id) {
		List<Account> accounts = ar.getAccountsByUser(id);
		Integer chId = 0;
		Integer svId = 0;
		Double chBal = new Double("0") ;
		Double svBal = new Double("0") ;
		
		
		for ( Account acc : accounts) { 
		
			if(acc.getType().equals("checking") ) {
				chId = acc.getId();
				chBal = acc.getBalance();
			}
			
			else if(acc.getType().equals("saving") ) {
				svId = acc.getId();
				svBal = acc.getBalance();
			}
		
		}
		
//		System.out.println("1. Checking to Saving\n" + "2. Saving to Checking\n");	
		transferMenu = true;
		
		while(transferMenu) {
			System.out.println();
			System.out.println("Choose a command below: ");
			System.out.println("1. Checking to Saving");
			System.out.println("2. Savings to Checkings");
			System.out.println("0. Cancel");
			Integer input = Integer.valueOf(scanner.nextLine());
			
			switch (input) {
			case 1: { //Checking to Saving
				System.out.println("Your current balance in checking is: " + chBal);
				System.out.println("Your current balance in saving is: " + svBal);
				System.out.println("How much would you like to transfer from checking to saving?");
				Double trans = new Double(scanner.nextLine());

				// Checking to see if input is valid.
				if(trans >= 0) {
						if (trans.compareTo(chBal) == -1 || trans.compareTo(chBal) == 0) {
							tr.addTransaction(chId, svId, trans, "transfer", "pending");
		
							// math for transfer
							chBal = chBal - trans;
							svBal = svBal + trans;
		
							// editing accounts in database
							ar.updateAccount(chId, chBal);
							ar.updateAccount(svId, svBal);
		
							// return confirmation
							System.out.println("Your current balance in checking is now: " + chBal);
							System.out.println("Your current balance in saving is now: " + svBal);
							
						} else {
							System.out.println("Invalid input, input cannot be larger than your total in checking");
					}
				}else {
					System.out.println("Input cannot be a negative value");
				}
			
				break;
			}
			case 2: { //Saving to Checking
					System.out.println("Your current balance in checking is: " + chBal);
					System.out.println("Your current balance in saving is: " + svBal);
					System.out.println("How much would you like to transfer from saving to checking?");
					Double trans = new Double(scanner.nextLine());

					// Checking to see if input is valid.
					if (trans >=0) {
						if (trans.compareTo(svBal) == -1 || trans.compareTo(svBal) == 0) {
							tr.addTransaction(svId, chId, trans, "transfer", "pending");
	
							// math for transfer
							svBal = svBal - (trans);
							chBal = chBal + (trans);
	
							// editing accounts in database
							ar.updateAccount(chId, chBal);
							ar.updateAccount(svId, svBal);
	
							// return confirmation
							System.out.println("Your current balance in checking is now: " + chBal);
							System.out.println("Your current balance in saving is now: " + svBal);
	
						} else {
							System.out.println("Invalid input, input cannot be larger than your total in saving");
						}
		
					}
					else {
						System.out.println("Input cannot be a negative value");
					}
					break;
				} 

			case 0: {
	
				System.out.println("Transfer Menu Closed");
				transferMenu = false;
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
