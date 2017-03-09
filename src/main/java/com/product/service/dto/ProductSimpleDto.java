package com.product.service.dto;

import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class ProductSimpleDto {


    private long id;

    private String name;

    private long categoryId;

    private List<Long> tagIds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}
