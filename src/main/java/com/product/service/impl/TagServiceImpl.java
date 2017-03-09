package com.product.service.impl;

import com.product.data.entity.Tag;
import com.product.data.repository.TagRepository;
import com.product.service.TagService;
import com.product.service.dto.TagCreateDto;
import com.product.service.dto.TagSimpleDto;
import com.product.util.TagConverter;

import java.util.List;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public TagSimpleDto findById(Long id) {
        Tag tag = tagRepository.findById(id);
        return TagConverter.convertToDto(tag);
    }

    @Override
    public TagSimpleDto create(TagCreateDto tagCreateDto) {
        Tag tag = new Tag();
        tag.setName(tagCreateDto.getName());
        Tag createdTag = tagRepository.create(tag);
        return TagConverter.convertToDto(createdTag);
    }

    @Override
    public List<TagSimpleDto> findAll() {
        List<Tag> tags = tagRepository.findAll();
        return TagConverter.convertToDto(tags);
    }


}
