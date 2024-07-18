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
import jakarta.persistence.Table;
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
@Table(name = "stock_order")
@Entity
public class Order {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int orderId;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonBackReference("user-orders")
	    private User user;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "stock_id", nullable = false)
	    @JsonBackReference("stock-oreder")
	    private Stock stock;

	    @Column(nullable = false)
	    private String orderType;

	    @Column(nullable = false)
	    private String orderAction;

	    @Column(nullable = false)
	    private Integer quantity;

	    private Double limitPrice;

	    @Column(nullable = false)
	    private String status;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(nullable = false)
	    private Date createdAt;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date updatedAt;

}
