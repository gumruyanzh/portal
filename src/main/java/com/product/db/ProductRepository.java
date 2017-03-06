package com.product.db;

import com.product.core.Product;

import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/6/17.
 */
public interface ProductRepository {
    Product findById(Long id);

    long create(Product product);

    List<Product> findAll();
}
