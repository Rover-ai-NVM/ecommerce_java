package com.ecommerce.shop_backend.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "categories")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Category { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
 
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getName(){
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
}