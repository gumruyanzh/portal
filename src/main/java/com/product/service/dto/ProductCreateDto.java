package com.product.service.dto;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class ProductCreateDto {

    private String name;
    private long categoryId;

    public ProductCreateDto() {
    }

    public ProductCreateDto(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
