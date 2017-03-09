package com.product.data.repository.impl;

import com.product.data.entity.Tag;
import com.product.data.repository.TagRepository;
import com.scottescue.dropwizard.entitymanager.UnitOfWork;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by zhirayrg on 3/8/2017.
 */
public class TagRepositoryImpl implements TagRepository {

    private EntityManager em;

    public TagRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @UnitOfWork(transactional = false)
    @Override
    public Tag findById(Long id) {
        return em.find(Tag.class, id);
    }

    @UnitOfWork
    @Override
    public Tag create(Tag tag) {
        em.persist(tag);
        return tag;
    }

    @UnitOfWork(transactional = false)
    @Override
    public List<Tag> findAll() {
        return em.createQuery("select t from Tag t").getResultList();
    }

}
