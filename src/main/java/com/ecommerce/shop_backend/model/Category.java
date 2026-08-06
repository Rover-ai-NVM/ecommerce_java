package com.ecommerce.shop_backend.model

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Category{
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

}