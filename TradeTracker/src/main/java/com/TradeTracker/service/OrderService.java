package com.TradeTracker.service;

import java.util.List;

import com.TradeTracker.entity.Order;

public interface OrderService {

	List<Order> getAllOrders();
    Order getOrderById(int orderId);
    Order createOrder(Order order);
    Order updateOrder(int orderId, Order orderDetails);
    void deleteOrder(int orderId);
}
