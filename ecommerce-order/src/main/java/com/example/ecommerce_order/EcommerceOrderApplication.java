package com.example.ecommerce_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrderApplication.class, args);
	}

}
