package com.product.service.impl;

import com.product.data.entity.Category;
import com.product.data.repository.CategoryRepository;
import com.product.service.CategoryService;
import com.product.service.dto.CategoryCreateDto;
import com.product.service.dto.CategorySimpleDto;
import com.product.util.CategoryConverter;

import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorySimpleDto findById(Long id) {
        Category category = categoryRepository.findById(id);
        return CategoryConverter.convertToDto(category);
    }

    @Override
    public CategorySimpleDto create(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        Category createdCategory = categoryRepository.create(category);
        return CategoryConverter.convertToDto(createdCategory);
    }

    @Override
    public List<CategorySimpleDto> findAll() {

        List<Category> categories = categoryRepository.findAll();
        return CategoryConverter.convertToDto(categories);
    }
}
