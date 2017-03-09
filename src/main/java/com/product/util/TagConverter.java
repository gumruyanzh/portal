package com.product.util;

import com.product.data.entity.Tag;
import com.product.service.dto.TagSimpleDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public class TagConverter {

    public static TagSimpleDto convertToDto(Tag tag){
        TagSimpleDto simpleDto = new TagSimpleDto();
        simpleDto.setName(tag.getName());
        simpleDto.setId(tag.getId());
        return simpleDto;
    }
    public static List<TagSimpleDto> convertToDto(List<Tag> categories){

        return categories.stream().map(TagConverter::convertToDto).collect(Collectors.toList());
    }
}
