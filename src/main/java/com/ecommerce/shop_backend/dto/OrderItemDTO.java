/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author merdi
 */
public class OrderItemDTO {
    
    @NotNull(message = "L'ID du produit est obligatoire")
    private Long productId;
    
    @NotNull (message = "La quantité est obligatoire")
    @Min(value = 1, message = "La quantité doit être d'au moins 1")
    private Integer quantity;
    
    public OrderItemDTO(){}
    
    public Long getProductId(){
        return productId;
    }
    public void setProductId(Long productId){
        this.productId = productId;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
