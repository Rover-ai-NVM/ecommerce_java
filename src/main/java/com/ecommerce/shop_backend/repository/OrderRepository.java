/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.repository;

import com.ecommerce.shop_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
        
/**
 *
 * @author merdi
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
