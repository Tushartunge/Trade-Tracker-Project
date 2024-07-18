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

import com.TradeTracker.entity.Watchlist;
import com.TradeTracker.service.WatchlistService;

@RestController
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @GetMapping("/watchlists")
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @GetMapping("/watchlists/{watchlistId}")
    public ResponseEntity<Watchlist> getWatchlistById(@PathVariable int watchlistId) {
        Watchlist watchlist = watchlistService.getWatchlistById(watchlistId);
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
    }

    @PostMapping("/watchlists")
    public ResponseEntity<Watchlist> createWatchlist(@RequestBody Watchlist watchlist) {
        Watchlist createdWatchlist = watchlistService.createWatchlist(watchlist);
        return new ResponseEntity<>(createdWatchlist, HttpStatus.CREATED);
    }

    @DeleteMapping("/watchlists/{watchlistId}")
    public ResponseEntity<?> deleteWatchlist(@PathVariable int watchlistId) {
        watchlistService.deleteWatchlist(watchlistId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
