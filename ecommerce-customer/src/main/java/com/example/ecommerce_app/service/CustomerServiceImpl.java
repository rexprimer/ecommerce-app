package com.example.ecommerce_app.service;

import com.example.ecommerce_app.exception.NotFoundException;
import com.example.ecommerce_app.model.Customer;
import com.example.ecommerce_app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        try {
            return  customerRepository.save(customer);
        }
        catch (Exception e) {
            throw new RuntimeException("Error saving customer");
        }
    }

    public List<Customer> saveAllCustomers(List<Customer> customers) {
        try {
            return customerRepository.saveAll(customers);
        } catch (Exception e) {
            throw new RuntimeException("Error saving customers: " + e.getMessage(), e);
        }

    }

    public Optional<Customer> getCustomerById(Long id) {
        Optional<Customer> customer =  customerRepository.findById(id);
        if(customer.isEmpty()) {
            throw new NotFoundException("Customer", id);
        }
        return customer;
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public void deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()) {
            throw new NotFoundException("Customer", id);
        }
        customerRepository.deleteById(id);
    }
}
