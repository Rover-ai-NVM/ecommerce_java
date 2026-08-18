/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.controller;

import com.ecommerce.shop_backend.dto.OrderRequestDTO;
import com.ecommerce.shop_backend.model.Order;
import com.ecommerce.shop_backend.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author merdi
 */
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
    
    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        return orderService.createOrderFromDTO(orderRequestDTO);
    }
}
