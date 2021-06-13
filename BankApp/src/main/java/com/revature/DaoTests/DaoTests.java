package com.revature.DaoTests;

import org.junit.Assert;
import org.junit.Test;

import com.revature.models.Account;
import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoImpl;


public class DaoTests {
	
	
	private AccountRepo account1 = new AccountRepoImpl();
	
	@Test
	public void grabAccountTest() {
		
		Integer id = 1;
		Double balance = new Double(100.0);
		String type = "checking";
		String status = "approved";
		
		Account accountExpected = new Account(id,balance,type,status);
		
		Account checkedAccount = account1.getAccountById(id);
		
		System.out.println(accountExpected);
		System.out.println(checkedAccount);
		Assert.assertEquals(accountExpected, checkedAccount);
		
	}

}