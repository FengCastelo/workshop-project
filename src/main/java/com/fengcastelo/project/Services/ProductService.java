package com.fengcastelo.project.Services;

import com.fengcastelo.project.Model.Entities.Category;
import com.fengcastelo.project.Model.Entities.Product;
import com.fengcastelo.project.Repositories.CategoryRepository;
import com.fengcastelo.project.Repositories.ProductRepository;
import com.fengcastelo.project.Services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product obj) {
        Set<Category> categorySet = new HashSet<>();
        for(Category cat : obj.getCategories()) {
            Category existing = categoryRepository.findById(cat.getId()).orElseThrow(() -> new RuntimeException("Category Not Found: " + cat.getId()));
            categorySet.add(existing);
        }
        obj.setCategories(categorySet);
        return productRepository.save(obj);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
