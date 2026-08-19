/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.service;

import com.ecommerce.shop_backend.dto.OrderRequestDTO;
import com.ecommerce.shop_backend.exception.ResourceNotFoundException;
import com.ecommerce.shop_backend.model.Order;
import com.ecommerce.shop_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author merdi
 */

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
        
    public Order createOrder(OrderRequestDTO orderRequest){
       Order order = new Order();
       order.setCustomerName(orderRequest.getCustomerName());
       
       BigDecimal total = BigDecimal.ZERO;
       
       order.setTotalAmount(total);
       
       return orderRepository.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    
    public Order getOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> {
            return new ResourceNotFoundException("Commande introuvable avec l'id:"+ id);
        });
    }
    public Order createOrderFromDTO(OrderRequestDTO orderRequestDTO){
        return new Order();
    }
    
}
