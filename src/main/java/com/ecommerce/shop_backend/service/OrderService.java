/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.service;

import com.ecommerce.shop_backend.dto.OrderRequestDTO;
import com.ecommerce.shop_backend.exception.ResourceNotFoundException;
import com.ecommerce.shop_backend.model.Order;
import com.ecommerce.shop_backend.model.OrderItem;
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
    
    @Autowired
    private ProductRepository productRepository;
    
    public Order createOrder(Order orderRequest){
        BigDecimal total = BigDecimal.ZERO;
        
        for (OrderItem item : orderRequest.getItem()){
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(()-> new ResourceNotFoundException("Produit introuvable avec l'id : " + item.getProduct().getId()));
            
            item.setProduct(product);
            item.setPrice(product.getPrice());
            
            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(itemTotal);
            
            //Mise à jour du stock
            if (product.getStock() < item.getQuantity()){
                throw new RuntimeException("Stock insuffisant pour le produit:" + product.getName());
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }
        
        orderRequest.setTotalAmount(total);
        return orderRepository.save(orderRequest);
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
