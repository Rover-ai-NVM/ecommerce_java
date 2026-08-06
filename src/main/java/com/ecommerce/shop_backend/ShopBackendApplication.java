package com.ecommerce.shop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopBackendApplication {

    public static void main(String[] args) {
        // Start Spring Boot application
        SpringApplication.run(ShopBackendApplication.class, args);
        // Simple startup message to aid debugging in IDEs
        System.out.println("ShopBackendApplication started");
    }
}
