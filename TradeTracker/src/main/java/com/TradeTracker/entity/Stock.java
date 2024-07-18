package com.TradeTracker.entity;


import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Stock {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;

    @Column(nullable = false, unique = true)
    private String symbol;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String market;

    @Column(nullable = false)
    private String sector;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("stock-transaction")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("stock-portfolio")
    private Set<Portfolio> portfolios;

    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("stock-watchlist")
    private Set<Watchlist> watchlists;

    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("stock-oreder")
    private Set<Order> orders;

    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("stock-market")
    private Set<MarketData> marketData;

}
