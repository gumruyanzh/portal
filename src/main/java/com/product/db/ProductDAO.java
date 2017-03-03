package com.product.db;

import com.product.core.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class ProductDAO extends AbstractDAO<Product> {

    public ProductDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    Product findById(Long id){
        return get(id);
    }

    public Product create(Product product) {
        return persist(product);
    }
}
