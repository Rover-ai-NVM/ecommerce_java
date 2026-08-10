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
        return this.id;
    }
}