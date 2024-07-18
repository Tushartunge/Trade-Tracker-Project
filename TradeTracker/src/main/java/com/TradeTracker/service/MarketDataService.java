package com.TradeTracker.service;

import java.util.List;

import com.TradeTracker.entity.MarketData;

public interface MarketDataService {
	
	List<MarketData> getAllMarketData();
    MarketData getMarketDataById(int marketDataId);
    MarketData createMarketData(MarketData marketData);
    MarketData updateMarketData(int marketDataId, MarketData marketData);
    void deleteMarketData(int marketDataId);

}
