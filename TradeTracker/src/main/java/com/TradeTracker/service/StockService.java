package com.TradeTracker.service;

import java.util.List;

import com.TradeTracker.entity.Stock;

public interface StockService {
	
    Stock addStock (Stock stock);
	
	Stock getStockbyId(int stockId);
	
	Stock getStockbySymbol(String symbol);
	
	List<Stock> getAllStocks();
	

}
