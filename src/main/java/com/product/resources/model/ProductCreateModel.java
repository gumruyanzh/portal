package com.product.resources.model;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhirayrg on 3/7/2017.
 */
public class ProductCreateModel {

    private String name;
    private long categoryId;
    private List<Long> tagIds;

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
