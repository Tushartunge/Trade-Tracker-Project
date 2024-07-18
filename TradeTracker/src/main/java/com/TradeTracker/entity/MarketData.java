package com.TradeTracker.entity;


import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class MarketData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int marketDataId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id", nullable = false)
    @JsonBackReference("stock-market")
    private Stock stock;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Double openPrice;

    @Column(nullable = false)
    private Double closePrice;

    @Column(nullable = false)
    private Double highPrice;

    @Column(nullable = false)
    private Double lowPrice;

    @Column(nullable = false)
    private Long volume;


}
