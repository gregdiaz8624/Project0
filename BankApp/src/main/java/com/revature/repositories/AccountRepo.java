package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;

public interface AccountRepo {

	Account getAccountById(Integer id);
	List<Account> getAccountsByUser(Integer id);
	void updateAccount(Integer id, Double balance);
	void addAccount(Integer id, Account account);
	Double getBalance(Integer id, String type);
	Integer getAccountId(Integer id, String type);
	void appoveAccount(Integer id);
	void denyAccount(Integer id);

}
