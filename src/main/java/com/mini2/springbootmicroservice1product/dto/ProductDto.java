package com.mini2.springbootmicroservice1product.dto;

import com.mini2.springbootmicroservice1product.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String vendor;
    private Double price;
    private Long categoryId;
    private LocalDateTime created;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setVendor(product.getVendor());
        this.setPrice(product.getPrice());
        this.setCategoryId(product.getCategory().getId());
        this.setCreated(product.getCreateTime());
    }
}
