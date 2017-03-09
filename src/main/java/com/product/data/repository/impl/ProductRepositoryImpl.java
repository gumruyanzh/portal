package com.product.data.repository.impl;

import com.product.data.entity.Category;
import com.product.data.entity.Tag;
import com.product.data.repository.ProductRepository;
import com.product.data.entity.Product;
import com.scottescue.dropwizard.entitymanager.UnitOfWork;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager em;

    private CriteriaBuilder cb;
    private CriteriaQuery<Product> q;
    private Root<Product> c;


    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @UnitOfWork(transactional = false)
    @Override
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @UnitOfWork
    @Override
    public Product create(Product product) {
        em.persist(product);
        return product;
    }


    @UnitOfWork(transactional = false)
    @Override
    public List<Product> findAll() {
        cb = em.getCriteriaBuilder();
        q  = cb.createQuery(Product.class);
        c = q.from(Product.class);
        q.select(c);
        return em.createQuery(q).getResultList();
    }

    @UnitOfWork(transactional = false)
    @Override
    public List<Product> findProductsByCategoryId(Long categoryId) {
        cb = em.getCriteriaBuilder();
        q  = cb.createQuery(Product.class);
        c = q.from(Product.class);
        q.select(c);
        q.where(cb.equal(c.get("category_id"),categoryId));
        return em.createQuery(q).getResultList();
    }

    @UnitOfWork(transactional = false)
    @Override
    public List<Product> findProductsByTagId(Long tag) {
        cb = em.getCriteriaBuilder();
        q  = cb.createQuery(Product.class);
        c = q.from(Product.class);
        q.select(c);
        q.where(cb.equal(c.get("tag_id"),tag));
        return em.createQuery(q).getResultList();
    }

}
