package com.mini2.springbootmicroservice1product.service;

import com.mini2.springbootmicroservice1product.model.Category;
import com.mini2.springbootmicroservice1product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
    @Override
    public Optional<Category> readCategory(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
