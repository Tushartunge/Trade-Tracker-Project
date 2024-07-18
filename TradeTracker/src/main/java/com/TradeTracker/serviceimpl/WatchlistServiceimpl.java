package com.TradeTracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.Watchlist;
import com.TradeTracker.exception.StockIdNotFoundException;
import com.TradeTracker.repository.WatchlistRepository;
import com.TradeTracker.service.WatchlistService;
@Service
public class WatchlistServiceimpl implements WatchlistService{
	@Autowired
	WatchlistRepository watchlistRepository;

	@Override
	public List<Watchlist> getAllWatchlists() {
	    return watchlistRepository.findAll();
	}

	@Override
	public Watchlist getWatchlistById(int watchlistId) {
	    return watchlistRepository.findById(watchlistId)
	            .orElseThrow(() -> new StockIdNotFoundException("Watchlist id not found"));
	}

	@Override
	public Watchlist createWatchlist(Watchlist watchlist) {
	    return watchlistRepository.save(watchlist);
	}

	
	@Override
	public void deleteWatchlist(int watchlistId) {
	    Watchlist watchlistToDelete = watchlistRepository.findById(watchlistId)
	            .orElseThrow(() -> new StockIdNotFoundException("Watchlist id not found"));
	    
	    watchlistRepository.delete(watchlistToDelete);
	}


	
}
