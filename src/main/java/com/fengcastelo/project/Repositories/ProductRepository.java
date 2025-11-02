package com.fengcastelo.project.Repositories;

import com.fengcastelo.project.Model.Entities.Category;
import com.fengcastelo.project.Model.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
