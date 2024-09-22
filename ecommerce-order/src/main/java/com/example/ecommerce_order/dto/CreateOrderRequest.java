package com.example.ecommerce_order.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateOrderRequest {
    private Long customerId;
    private Map<Long, Integer> products;
}
