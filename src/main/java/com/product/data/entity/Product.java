package com.product.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */

@Entity
@Table(name = "product")
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    public Product() {}

    public Product(String name) {
        this.name=name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
