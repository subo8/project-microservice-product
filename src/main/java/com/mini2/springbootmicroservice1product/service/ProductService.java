package com.mini2.springbootmicroservice1product.service;

import com.mini2.springbootmicroservice1product.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> findAllProduct();
}
