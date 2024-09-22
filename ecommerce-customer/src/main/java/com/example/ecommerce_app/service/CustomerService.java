package com.example.ecommerce_app.service;

import com.example.ecommerce_app.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> saveAllCustomers(List<Customer> customers);
    public Optional<Customer> getCustomerById(Long id);
    public List<Customer> getAllCustomers();
    public void deleteCustomer(Long id);
}
