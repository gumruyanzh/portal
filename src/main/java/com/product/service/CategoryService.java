package com.product.service;

import com.product.service.dto.CategoryCreateDto;
import com.product.service.dto.CategorySimpleDto;

import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public interface CategoryService {

    CategorySimpleDto findById(Long id);
    CategorySimpleDto create(CategoryCreateDto category);
    List<CategorySimpleDto> findAll();
}
