/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;


/**
 *
 * @author merdi
 */
public class ProductDTO {
    
    private Long id;
    
    @NotBlank(message = "Le nom du produit est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String name;
    
    private String description;
    
    @NotNull(message = "Le prix est obigatoire")
    @Positive(message = "Le prix doit être strictement supérieur à 0")
    private BigDecimal price;
    
    @NotNull(message = "Le stock est obligatoire")
    @Min(value = 0, message = "Le stock ne peut pas être négatif")
    private Integer stock;
    
    private String imageUrl;
    
    @NotNull(message = "L'ID de la catégorie est obligatoire")
    private Long categoryId;
    
    public ProductDTO(){}
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    
    public Integer getStock(){
        return stock;
    }
    public void setStock(Integer stock){
        this.stock = stock;
    }
    
    public String getImageUrl(){
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
