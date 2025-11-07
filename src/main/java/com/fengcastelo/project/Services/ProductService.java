package com.fengcastelo.project.Services;

import com.fengcastelo.project.Model.Entities.Category;
import com.fengcastelo.project.Model.Entities.Product;
import com.fengcastelo.project.Repositories.CategoryRepository;
import com.fengcastelo.project.Repositories.ProductRepository;
import com.fengcastelo.project.Services.exceptions.DatabaseException;
import com.fengcastelo.project.Services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        for (Category cat : obj.getCategories()) {
            Category existing = categoryRepository.findById(cat.getId()).orElseThrow(() -> new RuntimeException("Category Not Found: " + cat.getId()));
            categorySet.add(existing);
        }
        obj.setCategories(categorySet);
        return productRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (
                EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (
                DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj){
        Product entity = productRepository.getReferenceById(id);
        updateData(entity, obj);
        return productRepository.save(entity);
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}
