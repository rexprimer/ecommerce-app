package com.example.ecommerce_order.service;

import com.example.ecommerce_order.dto.CreateOrderRequest;
import com.example.ecommerce_order.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {
    public List<Order> getAllOrders();
    public Optional<Order> findById(Long id);
    public Order createOrder(CreateOrderRequest createOrderRequest);
    public Order updateOrder(Long orderId, Long customerId, Map<Long, Integer> productMap);

}
