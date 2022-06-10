package com.mini2.springbootmicroservice1product.repository;

import com.mini2.springbootmicroservice1product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //findBy + fieldName
    Category findByCategoryName(String categoryName);
}
