package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TradeTracker.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
