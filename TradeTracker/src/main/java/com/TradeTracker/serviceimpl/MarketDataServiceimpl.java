package com.TradeTracker.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.MarketData;
import com.TradeTracker.exception.StockIdNotFoundException;
import com.TradeTracker.repository.MarketDataRepository;
import com.TradeTracker.service.MarketDataService;

@Service
public class MarketDataServiceimpl implements MarketDataService{
	@Autowired
	MarketDataRepository mdRepo;

	@Override
	public List<MarketData> getAllMarketData() {
		
		return mdRepo.findAll();
	}

	@Override
	public MarketData getMarketDataById(int marketDataId) {
		
		return mdRepo.findById(marketDataId).
				orElseThrow(()-> new StockIdNotFoundException("MarketData id is not corrected"));
	}

	@Override
	public MarketData createMarketData(MarketData marketData) {
		
		return mdRepo.save(marketData);
	}

	@Override
	public MarketData updateMarketData(int marketDataId, MarketData marketData) {
		MarketData UpdateMarket = mdRepo.findById(marketDataId).
				orElseThrow(()-> new StockIdNotFoundException("MarketData id is not corrected"));
		        UpdateMarket.setVolume(marketData.getVolume());
		        UpdateMarket.setOpenPrice(marketData.getOpenPrice());
		        UpdateMarket.setClosePrice(marketData.getClosePrice());
		        mdRepo.save(UpdateMarket);
		return UpdateMarket;
	}

	@Override
	public void deleteMarketData(int marketDataId) {
		MarketData deleteMarket = mdRepo.findById(marketDataId).
				orElseThrow(()-> new StockIdNotFoundException("MarketData id is not corrected"));
		        mdRepo.delete(deleteMarket);
		
	}

	
}
