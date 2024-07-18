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

import com.TradeTracker.entity.MarketData;
import com.TradeTracker.service.MarketDataService;

@RestController
public class MarketDataController {

    @Autowired
    private MarketDataService marketDataService;

    @GetMapping("/marketdata")
    public List<MarketData> getAllMarketData() {
        return marketDataService.getAllMarketData();
    }

    @GetMapping("/marketdata/{marketDataId}")
    public ResponseEntity<MarketData> getMarketDataById(@PathVariable int marketDataId) {
        MarketData marketData = marketDataService.getMarketDataById(marketDataId);
        return new ResponseEntity<>(marketData, HttpStatus.OK);
    }

    @PostMapping("/marketdata")
    public ResponseEntity<MarketData> createMarketData(@RequestBody MarketData marketData) {
        MarketData createdMarketData = marketDataService.createMarketData(marketData);
        return new ResponseEntity<>(createdMarketData, HttpStatus.CREATED);
    }

    @PutMapping("/marketdata/{marketDataId}")
    public ResponseEntity<MarketData> updateMarketData(@PathVariable int marketDataId, @RequestBody MarketData marketData) {
        MarketData updatedData = marketDataService.updateMarketData(marketDataId, marketData);
        return new ResponseEntity<>(updatedData, HttpStatus.OK);
    }

    @DeleteMapping("/marketdata/{marketDataId}")
    public ResponseEntity<?> deleteMarketData(@PathVariable int marketDataId) {
        marketDataService.deleteMarketData(marketDataId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

