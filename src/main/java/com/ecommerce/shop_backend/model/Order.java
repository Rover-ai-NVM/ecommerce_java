/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author merdi
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime orderDate;
    
    private String status; // ex: PENDING, COMPLETED
    
    private BigDecimal totalAmount;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();
    
    public Order(){
        this.orderDate = LocalDateTime.now();
        this.status = "PENDING";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public LocalDateTime getOrderDate(){
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate){
        this.orderDate = orderDate;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public BigDecimal getTotalAmount(){
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount){
        this.totalAmount = totalAmount;
    }
    
    public List<OrderItem> getItem(){
        return items;
    }
    public void setItems(List<OrderItem> items){
        this.items = items;
    }
}
