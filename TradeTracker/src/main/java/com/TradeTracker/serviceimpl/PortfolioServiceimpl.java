package com.TradeTracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.Portfolio;
import com.TradeTracker.exception.StockIdNotFoundException;
import com.TradeTracker.repository.PortfolioRepository;
import com.TradeTracker.service.PortfolioService;
@Service
public class PortfolioServiceimpl implements PortfolioService{

	@Autowired
	PortfolioRepository portfolioRepo;

	@Override
	public List<Portfolio> getAllPortfolios() {
	    return portfolioRepo.findAll();
	}

	@Override
	public Portfolio getPortfolioById(int portfolioId) {
	    return portfolioRepo.findById(portfolioId)
	            .orElseThrow(() -> new StockIdNotFoundException("Portfolio id not found"));
	}

	@Override
	public Portfolio createPortfolio(Portfolio portfolio) {
	    return portfolioRepo.save(portfolio);
	}

//	@Override
//	public Portfolio updatePortfolio(int portfolioId, Portfolio portfolioDetails) {
//	    Portfolio updatedPortfolio = portfolioRepo.findById(portfolioId)
//	            .orElseThrow(() -> new StockIdNotFoundException("Portfolio id not found"));
//	    
//	    // Update portfolio details
//	    updatedPortfolio.set(portfolioDetails.getName());
//	    updatedPortfolio.setDescription(portfolioDetails.getDescription());
//	    
//	    portfolioRepo.save(updatedPortfolio);
//	    
//	    return updatedPortfolio;
//	}

	@Override
	public void deletePortfolio(int portfolioId) {
	    Portfolio portfolioToDelete = portfolioRepo.findById(portfolioId)
	            .orElseThrow(() -> new StockIdNotFoundException("Portfolio id not found"));
	    
	    portfolioRepo.delete(portfolioToDelete);
	}

	

}
