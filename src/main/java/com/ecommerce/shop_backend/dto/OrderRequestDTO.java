/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 *
 * @author merdi
 */
public class OrderRequestDTO {
    
    @NotEmpty(message = "La commande doit contenir au moins un article")
    @Valid
    private List<OrderItemDTO> items;
    
    public OrderRequestDTO(){}
    
    public List<OrderItemDTO> getItems(){
        return items;
    }
    
    public void setItems(List<OrderItemDTO> items){
        this.items = items;
    }
}
