package com.TradeTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TradeTracker.entity.Stock;
import com.TradeTracker.entity.Transaction;
import com.TradeTracker.entity.User;
import com.TradeTracker.service.TransactionService;

import jakarta.validation.Valid;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService tservice;
	
	Transaction transaction;
	
	@PostMapping("/Transaction/addtransaction")
	public ResponseEntity<Transaction>createTransaction(@Valid @RequestBody Transaction transaction){
		return new ResponseEntity<Transaction>(tservice.createTransaction(transaction),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Transaction/getTransactionById/{transactionId}")
	public ResponseEntity<Transaction>getTransactionById(@PathVariable ("transactionId") int transactionId){
		
		return new ResponseEntity<Transaction>(tservice.getTransactionById(transactionId),HttpStatus.OK);
		
	}
	
	@GetMapping("/Transaction/getAllTransactions")
    public List<Transaction> getAllTransactions() {
		
		return tservice.getAllTransactions();
 

}
	
	@PutMapping("/Transaction/updateTransaction/{transactionId}")
	public ResponseEntity<String> updateTransaction(@RequestBody Transaction transaction, @PathVariable ("transactionId") int transactionId){
		
		 tservice.updateTransaction(transaction, transactionId);
		 return new ResponseEntity<String>("Transaction update Sucessfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/Transaction/deleteTransaction/{transactionId}")
	public ResponseEntity<String> deleteTransaction(@PathVariable ("transactionId") int transactionId)
	{
		tservice.deleteTransaction(transactionId);
		return new ResponseEntity<String>("Transaction Deleted Sucessfully", HttpStatus.OK);
	}

}
