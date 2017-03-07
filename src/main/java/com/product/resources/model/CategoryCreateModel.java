package com.product.resources.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.FormParam;

/**
 * Created by zhirayrg on 3/7/2017.
 */
public class CategoryCreateModel {

    @JsonProperty("name")
    private String name;

    public CategoryCreateModel() {
    }

    public CategoryCreateModel(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
