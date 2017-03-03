package com.product.core;

import javax.persistence.*;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */

@Entity
@Table(name = "product")
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
}
