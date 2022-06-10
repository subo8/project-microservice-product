package com.mini2.springbootmicroservice1product.repository;

import com.mini2.springbootmicroservice1product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //findBy + fieldName
}
