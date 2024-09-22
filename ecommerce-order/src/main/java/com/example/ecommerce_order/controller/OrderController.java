package com.example.ecommerce_order.controller;

import com.example.ecommerce_order.dto.CreateOrderRequest;
import com.example.ecommerce_order.model.Order;
import com.example.ecommerce_order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(order.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(
            @RequestBody CreateOrderRequest createOrderRequest ){
        Order updateOrder = orderService.createOrder(createOrderRequest);
        if (updateOrder != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(updateOrder);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long orderId,
            @RequestBody CreateOrderRequest request) {
        Order updatedOrder = orderService.updateOrder(orderId, request.getCustomerId(), request.getProducts());
        if (updatedOrder != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedOrder);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
