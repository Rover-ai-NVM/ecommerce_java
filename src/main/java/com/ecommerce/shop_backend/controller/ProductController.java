package com.ecommerce.shop_backend.controller;

import com.ecommerce.shop_backend.dto.ProductDTO;
import jakarta.validation.Valid;
import com.ecommerce.shop_backend.model.Product;
import com.ecommerce.shop_backend.service.ProductService;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    
    @GetMapping("/paged")
    public Page<Product> getAllProductsPagination(Pageable pageable){
        return productService.getAllProductsPaginated(pageable);
    }
    
    @GetMapping("/search")
    public Page<Product> searchProducts(@RequestParam String name, Pageable pageable){
        return productService.searchProductsByName(name, pageable);
    }
    
    @GetMapping("/category/{categoryId}")
    public Page<Product> getProductsByCategory(@PathVariable Long categoryId, Pageable pageable){
       return productService.getProductsByCategory(categoryId, pageable);
    }
    
    @GetMapping("/filter-price")
    public Page<Product> filterByPrice(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max,
            Pageable pageable){
        return productService.getProducsByPriceRange(min,max, pageable);
    }
    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.createProductFromDTO(productDTO);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO){
        return productService.updateProductFromDTO(id, productDTO);
    }
}
 