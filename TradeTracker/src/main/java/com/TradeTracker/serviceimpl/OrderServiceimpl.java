package com.TradeTracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.Order;
import com.TradeTracker.exception.StockIdNotFoundException;
import com.TradeTracker.repository.OrderRepository;
import com.TradeTracker.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService{

	@Autowired
	OrderRepository orderRepo;

	@Override
	public List<Order> getAllOrders() {
	    return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(int orderId) {
	    return orderRepo.findById(orderId)
	            .orElseThrow(() -> new StockIdNotFoundException("Order id not found"));
	}

	@Override
	public Order createOrder(Order order) {
	    return orderRepo.save(order);
	}

	@Override
	public Order updateOrder(int orderId, Order orderDetails) {
	    Order updatedOrder = orderRepo.findById(orderId)
	            .orElseThrow(() -> new StockIdNotFoundException("Order id not found"));
	    
	    // Update order details
	    updatedOrder.setQuantity(orderDetails.getQuantity());
	    updatedOrder.setLimitPrice(orderDetails.getLimitPrice());
	    
	    orderRepo.save(updatedOrder);
	    
	    return updatedOrder;
	}

	@Override
	public void deleteOrder(int orderId) {
	    Order orderToDelete = orderRepo.findById(orderId)
	            .orElseThrow(() -> new StockIdNotFoundException("Order id not found"));
	    
	    orderRepo.delete(orderToDelete);
	}

}
