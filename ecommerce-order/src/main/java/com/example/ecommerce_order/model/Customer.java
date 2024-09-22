package com.example.ecommerce_order.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;
    private String name;
    private String email;
}
