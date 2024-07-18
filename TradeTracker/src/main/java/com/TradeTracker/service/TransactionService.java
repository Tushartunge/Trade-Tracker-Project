package com.TradeTracker.service;

import java.util.List;

import com.TradeTracker.entity.Transaction;

public interface TransactionService {
	
	 List<Transaction> getAllTransactions();
	 Transaction getTransactionById(int transactionId);
	 Transaction createTransaction(Transaction transaction);
	 Transaction updateTransaction( Transaction transaction, int transactionId);
	    void deleteTransaction(int transactionId);

}
