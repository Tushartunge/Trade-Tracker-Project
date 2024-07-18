package com.TradeTracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.Stock;
import com.TradeTracker.exception.StockIdNotFoundException;
import com.TradeTracker.repository.StockRepository;
import com.TradeTracker.service.StockService;

@Service
public class StockServiceimpl implements StockService{
	
	@Autowired
	StockRepository stockRepository;

	@Override
	public Stock addStock(Stock stock) {
		
		return stockRepository.save(stock);
	}

	@Override
	public Stock getStockbyId(int stockId) {
		
		return stockRepository.findById(stockId).
				orElseThrow(()-> new StockIdNotFoundException("Stock id is not corrected"));
				
	}

	@Override
	public Stock getStockbySymbol(String symbol) {
		
		return stockRepository.getStockbySymbol(symbol);
				
	}

	@Override
	public List<Stock> getAllStocks() {
		
		return stockRepository.findAll();
	}

}
