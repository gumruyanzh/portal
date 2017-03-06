package com.product.db;

import com.product.core.Product;
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
    public long create(Product product) {
        em.persist(product);
        em.flush();
        return product.getId();
    }


    @UnitOfWork(transactional = false)
    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p").getResultList();
    }
}
