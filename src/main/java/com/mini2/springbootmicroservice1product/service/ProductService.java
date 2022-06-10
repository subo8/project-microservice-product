package com.mini2.springbootmicroservice1product.service;

import com.mini2.springbootmicroservice1product.Exception.ProductNotExistException;
import com.mini2.springbootmicroservice1product.dto.ProductDto;
import com.mini2.springbootmicroservice1product.model.Category;
import com.mini2.springbootmicroservice1product.model.Product;

import java.util.List;

public interface ProductService {

//    Product saveProduct(Product product);

    void deleteProduct(Long productId);

//    List<Product> findAllProduct();

    List<ProductDto> listProducts();

    Product addProduct(ProductDto productDto, Category category);

    Long getProductById(Long productId) throws ProductNotExistException;

    Double getProductPrice(Long productId) throws ProductNotExistException;
}
