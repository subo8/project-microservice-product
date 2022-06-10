package com.mini2.springbootmicroservice1product.model;


import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name", length = 100, nullable = false)
    private String categoryName;
    @Column(name="description", length = 100, nullable = false)
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Product> products;

    public Category() {
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
}

