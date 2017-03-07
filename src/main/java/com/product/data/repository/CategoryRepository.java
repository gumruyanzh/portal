package com.product.data.repository;

import com.product.data.entity.Category;

import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public interface CategoryRepository {

    Category findById(Long id);
    Category create(Category category);
    List<Category> findAll();

}
