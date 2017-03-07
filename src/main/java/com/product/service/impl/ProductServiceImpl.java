package com.product.service.impl;

import com.product.data.entity.Category;
import com.product.data.entity.Product;
import com.product.data.repository.CategoryRepository;
import com.product.data.repository.ProductRepository;
import com.product.service.ProductService;
import com.product.service.dto.ProductCreateDto;
import com.product.service.dto.ProductSimpleDto;
import com.product.util.ProductConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TCE\zhirayrg on 3/6/17.
 */
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }


    @Override
    public ProductSimpleDto findById(Long id) {
        Product product = productRepository.findById(id);
        return ProductConverter.convertToDto(product);
    }

    @Override
    public ProductSimpleDto create(ProductCreateDto productCreateDto) {
        Category category = categoryRepository.findById(productCreateDto.getCategoryId());

        Product product = new Product();
        product.setName(productCreateDto.getName());
        product.setCategory(category);

        Product createdProduct = productRepository.create(product);

        return ProductConverter.convertToDto(createdProduct);
    }

    @Override
    public List<ProductSimpleDto> findAll() {

        List<Product> products = productRepository.findAll();

        return ProductConverter.convertToDto(products);

    }

    @Override
    public List<ProductSimpleDto> findProductsByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId);
        List<Product> products = productRepository.findProductsByCategory(category);

        return ProductConverter.convertToDto(products);

    }

}
