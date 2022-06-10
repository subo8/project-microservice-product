package com.mini2.springbootmicroservice1product.service;

import com.mini2.springbootmicroservice1product.Exception.ProductNotExistException;
import com.mini2.springbootmicroservice1product.dto.ProductDto;
import com.mini2.springbootmicroservice1product.model.Category;
import com.mini2.springbootmicroservice1product.model.Product;
import com.mini2.springbootmicroservice1product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }
    @Override
    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product(productDto, category);
        return product;
    }
    @Override
    public Product addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        return productRepository.save(product);
    }

    @Override
    public Long getProductById(Long productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get().getId();
    }

    @Override
    public Double getProductPrice(Long productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get().getPrice();
    }

    //Older function versions
//    @Override
//    public Product saveProduct(Product product) {
//        product.setCreateTime(LocalDateTime.now());
//        return productRepository.save(product);
//    }

//    @Override
//    public List<Product> findAllProduct() {
//        return productRepository.findAll();
//    }
}
