# E-Commerce Microservices with Eureka and API Gateway

1. ### Overview
   This project consists of an e-commerce application with multiple microservices: Product Service, Customer Service, and Order Service. It uses Eureka for service discovery and Spring Cloud Gateway for routing.

2. ### Architecture
- Eureka Server: Service discovery server running on port 8761.
- API Gateway: Routes requests to different services, running on port 9000.
- Product Service: Manages product data, running on port 8082.
- Customer Service: Manages customer data, running on port 8081.
- Order Service: Manages order data, running on port 8083.

3. ### Technologies Used
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- MySQL (for database)
- Swagger for API documentation
4. ### Getting Started
- Prerequisites
- Java 17 or higher
- Maven
- MySQL Server
- IDE (like IntelliJ IDEA or Eclipse)

5. ### Installation
- Clone the repository:

   ```bash
   git clone https://github.com/rexprimer/ecommerce-app
- Create a MySQL Database:Run the following SQL command to create the database:sql Copy code

- Configure Database Connection: Update the application.properties in the Customer and Product services to match your MySQL credentials if needed.

6. ### Running the Application

   a. Start Eureka Server:

   b. Start the Product Service:

   c. Start the Customer Service:

   d. Start the Order Service:

   e. Start the API Gateway:

7. ### Accessing the Services
- Eureka Dashboard: http://localhost:8761
- API Gateway:
  - Products: http://localhost:9000/product/**
  - Customers: http://localhost:9000/customer/**
  - Orders: http://localhost:9000/order/**
- API Documentation
Swagger UI: http://localhost:9000/swagger-ui.html

8. ### Contributing
   Contributions are welcome! Feel free to submit a pull request for enhancements or bug fixes.

9. ### License
This project is licensed under the MIT License.