/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.shop_backend.service;
import com.ecommerce.shop_backend.dto.ProductDTO;
import com.ecommerce.shop_backend.exception.ResourceNotFoundException;
import com.ecommerce.shop_backend.model.Category;
import com.ecommerce.shop_backend.model.Product;
import com.ecommerce.shop_backend.repository.CategoryRepository;
import com.ecommerce.shop_backend.repository.ProductRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
    
/**
 *
 * @author merdi
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
    
    public List<Product> getProductsByCategoryId(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }
    
    public Product saveProduct(Product product) {
        if(product.getCategory() != null ){
            Long categoryId = product.getCategory().getId();
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(()-> new RuntimeException("Categorie non trouvée"));
            product.setCategory(category);
            
        }
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product productDetails){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produit introuvable avec l'id : " + id));
        
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setImageUrl(productDetails.getImageUrl());
        
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Produit introuvable avec l'id : " + id));
        
        productRepository.delete(product);
    }

    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }
    
    public Page<Product>  getAllProductsPaginated(Pageable pageable){
        return productRepository.findAll(pageable);

    }
    
    public Page<Product>  searchProductsByName(String name, Pageable pageable){
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }
    
    public Page<Product>  getProductsByCategory(Long categoryId, Pageable pageable){
        return productRepository.findByCategoryId(categoryId, pageable);
    }
    
    public Page<Product>  getProducsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable){
        return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    }
    public Product createProductFromDTO(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setImageUrl(productDTO.getImageUrl());
    
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
        product.setCategory(category);
        
        return productRepository.save(product);
    }
    public Product updateProductFromDTO(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
        
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setImageUrl(productDTO.getImageUrl());
        
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Categorie introuvable"));
            product.setCategory(category);
        }
        
        return productRepository.save(product);
    }
}
