package com.TradeTracker.service;

import java.util.List;

import com.TradeTracker.entity.Portfolio;

public interface PortfolioService {
	
	List<Portfolio> getAllPortfolios();
    Portfolio getPortfolioById(int portfolioId);
    Portfolio createPortfolio(Portfolio portfolio);
    //Portfolio updatePortfolio(int portfolioId, Portfolio portfolioDetails);
    void deletePortfolio(int portfolioId);

}
