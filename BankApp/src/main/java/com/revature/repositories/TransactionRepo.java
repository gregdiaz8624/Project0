package com.revature.repositories;

import java.util.List;

import com.revature.models.Transaction;

public interface TransactionRepo {	
	
	void addTransaction(Integer from, Integer to, Double amount, String type, String status);
	void addTransaction(Double amount, String type, String status);
	void updateTransaction(Integer id);
	Transaction getTransactionById(Integer id);
	List<Transaction> getTransactions(Integer id);
	List<Transaction> getAllTransactions();
}