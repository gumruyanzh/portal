package com.product.resources.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public class TagCreateModel {

    @JsonProperty("name")
    private String name;

    public TagCreateModel() {
    }

    public TagCreateModel(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
