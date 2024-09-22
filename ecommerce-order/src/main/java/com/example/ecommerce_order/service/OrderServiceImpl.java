package com.example.ecommerce_order.service;

import com.example.ecommerce_order.dto.CreateOrderRequest;
import com.example.ecommerce_order.exception.NotFoundException;
import com.example.ecommerce_order.model.Customer;
import com.example.ecommerce_order.model.Order;
import com.example.ecommerce_order.model.Product;
import com.example.ecommerce_order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

//    private final OrderRepository orderRepository;
//    private final ProductRepository productRepository;
//    private final CustomerRepository customerRepository;
//
//    OrderServiceImpl(OrderRepository orderRepository,
//                     ProductRepository productRepository,
//                     CustomerRepository customerRepository) {
//        this.orderRepository = orderRepository;
//        this.productRepository = productRepository;
//        this.customerRepository = customerRepository;
//    }



//    private final String CUSTOMER_URL = "http://localhost:8081/customers";
//    private final String PRODUCT_URL = "http://localhost:8082/products";


    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${product.service.url}")
    private String productServiceUrl;

    OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public List<Order> getAllOrders() {
        try {
            return orderRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException("Error getting all orders");
        }
    }

    public Optional<Order> findById(Long id) {
        try{
            return orderRepository.findById(id);
        }
        catch (Exception e) {
            throw new RuntimeException("Error finding order by id");
        }
    }

    public Order createOrder(CreateOrderRequest createOrderRequest) {

        List<Product> products = new ArrayList<>();
        for (Long productId : createOrderRequest.getProducts().keySet()) {
//            Optional<Product> product = productRepository.findById(productId);
            Product product = restTemplate.getForObject(productServiceUrl + productId, Product.class);
            if (product != null) {
                products.add(product);
            }
            else {
                throw  new NotFoundException("Product", productId);
            }
        }
        Customer customer = restTemplate.getForObject(customerServiceUrl + createOrderRequest.getCustomerId(), Customer.class);
//       Optional<Customer> customer = customerRepository.findById(createOrderRequest.getCustomerId());
        if(customer != null) {
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            return orderRepository.save(order);

        }
        else {
            throw  new NotFoundException("Customer", createOrderRequest.getCustomerId());
        }
    }

    public Order updateOrder(Long OrderId, Long customerId, Map<Long, Integer> productMap) {

        List<Product> products = new ArrayList<>();
        for (Long productId : productMap.keySet()) {
//            Optional<Product> product = productRepository.findById(productId);
            Product product = restTemplate.getForObject(productServiceUrl + productId, Product.class);
            if (product != null) {
                products.add(product);
            }
            else{
                throw new RuntimeException("Product : "+productId +"not found");
            }
        }

//        Optional<Customer> customer = customerRepository.findById(customerId);
        Customer customer = restTemplate.getForObject(customerServiceUrl + customerId, Customer.class);
        if(customer != null)
        {
            Optional<Order> order = orderRepository.findById(OrderId);
            if(order.isPresent()) {
                Order orderToUpdate = order.get();
                orderToUpdate.setProducts(products);
                orderToUpdate.setCustomer(customer);
                return orderRepository.save(orderToUpdate);
            }
            else {
                throw new NotFoundException("Customer", OrderId);
            }
        }
        else {
            throw new NotFoundException("Customer", customerId);
        }
    }

}
