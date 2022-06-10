package com.mini2.springbootmicroservice1product.controller;

import com.mini2.springbootmicroservice1product.dto.ProductDto;
import com.mini2.springbootmicroservice1product.model.Category;
import com.mini2.springbootmicroservice1product.model.Product;
import com.mini2.springbootmicroservice1product.service.CategoryService;
import com.mini2.springbootmicroservice1product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>("category is invalid", HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        return new ResponseEntity<>(productService.addProduct(productDto, category), HttpStatus.CREATED);
    }

}
