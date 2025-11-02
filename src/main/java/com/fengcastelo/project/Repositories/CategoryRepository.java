package com.fengcastelo.project.Repositories;

import com.fengcastelo.project.Model.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
