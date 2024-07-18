package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TradeTracker.entity.MarketData;

public interface MarketDataRepository extends JpaRepository<MarketData, Integer>{

}
