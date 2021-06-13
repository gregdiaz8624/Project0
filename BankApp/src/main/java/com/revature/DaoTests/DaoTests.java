package com.revature.DaoTests;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.revature.models.Account;
import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoImpl;

public class DaoTests {

	private AccountRepo ar = new AccountRepoImpl();

	@Test
	public void addTest() {
		Double doub = new Double("300");
		Integer id = 1;
		Account expected = new Account(id, doub,"checking", "pending");
		Account check = ar.getAccountById(id);
		Assert.assertEquals(expected, check);
	}
	
	
}