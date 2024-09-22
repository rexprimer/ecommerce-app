package com.example.ecommerce_order.repository;

import com.example.ecommerce_order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
