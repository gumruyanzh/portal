package com.product.data.repository;

import com.product.data.entity.Tag;

import java.util.List;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public interface TagRepository {
    Tag findById(Long id);
    Tag create(Tag tag);
    List<Tag> findAll();

}
