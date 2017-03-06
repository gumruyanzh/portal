package com.product.db;

import com.product.core.Product;
import com.scottescue.dropwizard.entitymanager.UnitOfWork;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em=em;
    }

    @UnitOfWork(transactional = false)
    Product findById(Long id){
        return em.find(Product.class, id);
    }

    @UnitOfWork
    public long create(Product product) {
        em.persist(product);
        em.flush();
        return product.getId();
    }


    @UnitOfWork(transactional = false)
    public List<Product> findAll() {
        return em.createQuery("select p from Product p").getResultList();
    }
}
