package com.TradeTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TradeTracker.entity.Stock;
import com.TradeTracker.service.StockService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/")
public class StockController {
	
	@Autowired
	StockService sservice;
	
	 Stock stock;
	 
	 @PostMapping("/Stock")
		public ResponseEntity<Stock> addStock(@Valid @RequestBody Stock stock) {
			
			return new  ResponseEntity<Stock>(sservice.addStock(stock),HttpStatus.CREATED);
		}
		
		@GetMapping("/Stock/{stockId}")
	    public ResponseEntity<Stock> getStockbyId(@PathVariable ("stockId") int stockId) {
			
			return new  ResponseEntity<Stock>(sservice.getStockbyId(stockId),HttpStatus.OK);
		}
		
//		@GetMapping("/Stock/{symbol}")
//	    public ResponseEntity<Stock> getStockbySymbol(@PathVariable ("symbol") String symbol) {
//			
//			return new  ResponseEntity<Stock>(sservice.getStockbySymbol(symbol),HttpStatus.OK);
//		}
		
		@GetMapping("/Stock")
	    public List<Stock> getAllStocks() {
			
			return sservice.getAllStocks();
	 

}
}
