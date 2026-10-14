/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.service;

import com.ecommerce.shop_backend.dto.OrderItemDTO;
import com.ecommerce.shop_backend.dto.OrderRequestDTO;
import com.ecommerce.shop_backend.exception.ResourceNotFoundException;
import com.ecommerce.shop_backend.model.Order;
import com.ecommerce.shop_backend.model.Product;
import com.ecommerce.shop_backend.repository.OrderRepository;
import com.ecommerce.shop_backend.repository.ProductRepository;
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
    private ProductRepository productRepository;
    
    public Order createOrder(OrderRequestDTO orderRequest){
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        
        BigDecimal total = BigDecimal.ZERO;
        
        for(OrderItemDTO itemDTO : orderRequest.getItems()){
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(()-> new RuntimeException("Produ4it introuvable ID:"+ itemDTO.getProductId()));
            
            if (product.getStock()< itemDTO.getQuantity()){
                throw new RuntimeException("Stock insuffisant pour le produit:" + product.getName());
            }
            product.setStock(product.getStock()- itemDTO.getQuantity());
            productRepository.save(product);
            
            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(itemDTO.getQuantity()));
            total = total.add(itemTotal);
        }
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
