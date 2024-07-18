package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TradeTracker.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
