package com.product.data.repository;

import com.product.data.entity.Category;
import com.product.data.entity.Product;
import com.product.data.entity.Tag;

import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/6/17.
 */
public interface ProductRepository {
    Product findById(Long id);

    Product create(Product product);

    List<Product> findAll();

    List findProductsByCategoryId(Long category);

    List<Product> findProductsByTagId(Long tag);

}
