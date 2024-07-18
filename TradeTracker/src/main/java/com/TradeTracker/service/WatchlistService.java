package com.TradeTracker.service;

import java.util.List;

import com.TradeTracker.entity.Watchlist;

public interface WatchlistService {

	List<Watchlist> getAllWatchlists();
    Watchlist getWatchlistById(int watchlistId);
    Watchlist createWatchlist(Watchlist watchlist);
    void deleteWatchlist(int watchlistId);
}
