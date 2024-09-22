package com.example.ecommerce_app.controller;

import com.example.ecommerce_app.model.Customer;
import com.example.ecommerce_app.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

     private CustomerController(CustomerService customerService) {
         this.customerService = customerService;
     }

     @PostMapping()
     public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
         Customer saveCustomer = customerService.saveCustomer(customer);
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(saveCustomer);
     }

     @PostMapping("/saveAll")
     public ResponseEntity<List<Customer>> createAllCustomer(@RequestBody List<Customer> customers) {
         List<Customer> saveAllCustomers = customerService.saveAllCustomers(customers);
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(saveAllCustomers);
     }

     @GetMapping("/getAll")
     public List<Customer> getAllCustomers() {
         return customerService.getAllCustomers();
     }

     @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
         Optional<Customer> customer = customerService.getCustomerById(id);
         if(customer.isPresent()) {
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .body(customer.get());
         }
         else {
             return ResponseEntity
                     .status(HttpStatus.NOT_FOUND)
                     .body(null);
         }
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
         if(customerService.getCustomerById(id) != null) {
             customerService.deleteCustomer(id);
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .build();
         }
         else{
             return  ResponseEntity
                     .status(HttpStatus.OK)
                     .body(null);
         }
     }
}
