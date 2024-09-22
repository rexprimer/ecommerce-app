package com.example.ecommerce_order.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private double price;
    private int stock;
}
