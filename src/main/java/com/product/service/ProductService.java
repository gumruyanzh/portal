package com.product.service;

import com.product.data.entity.Category;
import com.product.data.entity.Product;
import com.product.service.dto.ProductCreateDto;
import com.product.service.dto.ProductSimpleDto;

import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/6/17.
 */
public interface ProductService {

    ProductSimpleDto findById(Long id);

    ProductSimpleDto create(ProductCreateDto productCreateDto);

    List<ProductSimpleDto> findAll();

    List<ProductSimpleDto> findProductsByCategoryId(Long categoryId);

    List<ProductSimpleDto> findProductsByTagId(Long tagId);

}
