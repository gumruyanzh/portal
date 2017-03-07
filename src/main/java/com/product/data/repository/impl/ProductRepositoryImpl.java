package com.product.data.repository.impl;

import com.product.data.entity.Category;
import com.product.data.repository.ProductRepository;
import com.product.data.entity.Product;
import com.scottescue.dropwizard.entitymanager.UnitOfWork;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager em;

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
        return em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public List<Product> findProductsByCategory(Category category) {
        Long categoryId = category.getId();
        return em.createQuery("select p from Product p where p.category_id := categoryId").getResultList();
    }
}
