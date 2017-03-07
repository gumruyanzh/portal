package com.product.util;

import com.product.data.entity.Category;
import com.product.service.dto.CategorySimpleDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class CategoryConverter {

    public static CategorySimpleDto convertToDto(Category category){
            CategorySimpleDto simpleDto = new CategorySimpleDto();
            simpleDto.setName(category.getName());
            simpleDto.setId(category.getId());
            return simpleDto;
    }
    public static List<CategorySimpleDto> convertToDto(List<Category> categories){

        return categories.stream().map(CategoryConverter::convertToDto).collect(Collectors.toList());
    }
}
