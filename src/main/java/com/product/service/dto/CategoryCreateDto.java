package com.product.service.dto;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class CategoryCreateDto {

    private String name;

    public CategoryCreateDto(String name) {
        this.name = name;
    }

    public CategoryCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
