package com.product.service.dto;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class ProductCreateDto {

    private String name;
    private long categoryId;
    private Optional<List<Long>> tagIds;

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

    public Optional<List<Long>> getTagIds() {
        return tagIds;
    }

    public void setTagIds(Optional<List<Long>> tagIds) {
        this.tagIds = tagIds;
    }
}
