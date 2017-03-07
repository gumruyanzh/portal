package com.product.data.repository.impl;

import com.product.data.entity.Category;
import com.product.data.repository.CategoryRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
public class CategoryRepositoryImpl implements CategoryRepository {

    private EntityManager em;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    @Override
    public Category create(Category category) {
        em.persist(category);
        return category;
    }

    @Override
    public List<Category> findAll() {
        return em.createQuery("select c from Category c").getResultList();
    }
}
