package com.TradeTracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.Transaction;
import com.TradeTracker.exception.StockIdNotFoundException;
import com.TradeTracker.exception.UserIdNotFoundException;
import com.TradeTracker.repository.TransactionRepository;
import com.TradeTracker.service.TransactionService;

@Service
public class TransactionServiceimpl implements TransactionService {
	
	@Autowired
	TransactionRepository transRepository;

	@Override
	public List<Transaction> getAllTransactions() {
		
		return transRepository.findAll();
	}

	@Override
	public Transaction getTransactionById(int transactionId) {
		
		return transRepository.findById(transactionId).
				orElseThrow(()-> new StockIdNotFoundException("Transaction id is not corrected"));
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		
		return transRepository.save(transaction);
	}

	

	@Override
	public void deleteTransaction(int transactionId) {
		Transaction DeleteTransaction= transRepository.findById(transactionId).
				orElseThrow(()-> new UserIdNotFoundException("Transaction id is not corrected"));
		transRepository.delete(DeleteTransaction);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction, int transactionId) {
		Transaction UpdateTransaction= transRepository.findById(transactionId).
				orElseThrow(()-> new UserIdNotFoundException("Transaction id is not corrected"));
		
		UpdateTransaction.setQuantity(transaction.getQuantity());
		UpdateTransaction.setTransactionType(transaction.getTransactionType());
		transRepository.save(UpdateTransaction);
		return UpdateTransaction;
	}

}
