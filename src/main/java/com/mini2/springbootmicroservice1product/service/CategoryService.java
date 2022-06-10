package com.mini2.springbootmicroservice1product.service;

import com.mini2.springbootmicroservice1product.model.Category;

import java.util.Optional;

public interface CategoryService {
    Category readCategory(String categoryName);

    Optional<Category> readCategory(Long categoryId);
}
