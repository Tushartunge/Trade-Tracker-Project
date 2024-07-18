package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TradeTracker.entity.Stock;

public interface StockRepository  extends JpaRepository<Stock, Integer>{
	
	@Query("select s from Stock s where s.symbol=?1 ")
	Stock getStockbySymbol(String symbol);

}
