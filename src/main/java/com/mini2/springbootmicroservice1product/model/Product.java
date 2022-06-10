package com.mini2.springbootmicroservice1product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mini2.springbootmicroservice1product.dto.ProductDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "vendor", length = 100, nullable = false)
    private String vendor;

    @Column(name = "price", length = 100, nullable = false)
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    Category category;

    public Product(){}
    public Product(ProductDto productDto, Category category) {
        this.createTime = LocalDateTime.now();
        this.name = productDto.getName();
        this.vendor = productDto.getVendor();
        this.price = productDto.getPrice();
        this.category = category;
    }
}
