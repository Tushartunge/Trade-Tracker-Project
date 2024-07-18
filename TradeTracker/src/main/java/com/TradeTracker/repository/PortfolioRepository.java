package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TradeTracker.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>{

}
