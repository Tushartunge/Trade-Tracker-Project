package com.TradeTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TradeTracker.entity.Portfolio;
import com.TradeTracker.service.PortfolioService;

@RestController
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/portfolios")
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @GetMapping("/portfolios/{portfolioId}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable int portfolioId) {
        Portfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    @PostMapping("/portfolios")
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
        return new ResponseEntity<>(createdPortfolio, HttpStatus.CREATED);
    }

   

    @DeleteMapping("/portfolios/{portfolioId}")
    public ResponseEntity<?> deletePortfolio(@PathVariable int portfolioId) {
        portfolioService.deletePortfolio(portfolioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
