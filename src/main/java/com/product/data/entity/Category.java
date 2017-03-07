package com.product.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Category(String name) {
        this.name = name;
    }
    public Category(){}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> product;

    public Long getId() {
        return id;
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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
