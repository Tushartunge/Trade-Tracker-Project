package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TradeTracker.entity.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {

}
