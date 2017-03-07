package com.product.resources.model;

/**
 * Created by zhirayrg on 3/7/2017.
 */
public class ProductCreateModel {

    private String name;
    private long categoryId;

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
