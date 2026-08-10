package com.ecommerce.shop_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;
    
    public void setCategory(Category category){
        this.category = category;
    }
    
    public Category getCategory(){
        return category;
    }
}