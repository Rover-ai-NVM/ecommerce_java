/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author merdi
 */

@Entity
@Table(name ="order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false )
    private Product product;
    
    private Integer quantity;
    
    private BigDecimal price;
    
    public OrderItem(){}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    
    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
}
