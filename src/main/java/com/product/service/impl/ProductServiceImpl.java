package com.product.service.impl;

import com.product.data.entity.Category;
import com.product.data.entity.Product;
import com.product.data.entity.Tag;
import com.product.data.repository.CategoryRepository;
import com.product.data.repository.ProductRepository;
import com.product.data.repository.TagRepository;
import com.product.service.ProductService;
import com.product.service.dto.ProductCreateDto;
import com.product.service.dto.ProductSimpleDto;
import com.product.util.ProductConverter;
import com.product.util.TagConverter;
import javaslang.control.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by TCE\zhirayrg on 3/6/17.
 */
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              TagRepository tagRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
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

        List<Tag> tags = new ArrayList<>();
        Option.ofOptional(productCreateDto.getTagIds()).get()
                .forEach(tagId->{
                    Tag tag = tagRepository.findById(tagId);
            tags.add(tag);
        });

        product.setTags(tags);

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
        List<Product> products = productRepository.findProductsByCategoryId(categoryId);

        return ProductConverter.convertToDto(products);

    }

    @Override
    public List<ProductSimpleDto> findProductsByTagId(Long tagId) {
        List<Product> products = productRepository.findProductsByTagId(tagId);

        return ProductConverter.convertToDto(products);
    }

}
