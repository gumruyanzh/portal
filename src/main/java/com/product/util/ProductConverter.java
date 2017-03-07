package com.product.util;

import com.product.data.entity.Product;
import com.product.service.dto.ProductSimpleDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class ProductConverter {

    public static List<ProductSimpleDto> convertToDto(List<Product> products){

        return products.stream().map(ProductConverter::convertToDto).collect(Collectors.toList());

    }

    public static ProductSimpleDto convertToDto(Product product){
        ProductSimpleDto simpleDto = new ProductSimpleDto();
        simpleDto.setId(product.getId());
        simpleDto.setCategoryId(product.getCategory().getId());
        simpleDto.setName(product.getName());
        return simpleDto;
    }

}
