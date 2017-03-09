package com.product.service.dto;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public class TagCreateDto {

    private String name;

    public TagCreateDto(String name) {
        this.name = name;
    }

    public TagCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
