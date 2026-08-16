package com.ecommerce.shop_backend.service;

import com.ecommerce.shop_backend.exception.ResourceNotFoundException;
import com.ecommerce.shop_backend.model.Category;
import com.ecommerce.shop_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    
    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }
    
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    //mettre à jour une categorie
    public Category updateCategory(Long id, Category categoryDetails){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Catégorie introuvable avec l'id : "+ id));
        
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        
        return categoryRepository.save(category);
    }
    
    //supprimer une categorie
    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Catégorie introuvable avec l'id : " + id));
        
        categoryRepository.delete(category);
    }
}
