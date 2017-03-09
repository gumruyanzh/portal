package com.product.service;

import com.product.service.dto.TagCreateDto;
import com.product.service.dto.TagSimpleDto;

import java.util.List;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public interface TagService {

    TagSimpleDto findById(Long id);
    TagSimpleDto create(TagCreateDto tagCreateDto);
    List<TagSimpleDto> findAll();
}
