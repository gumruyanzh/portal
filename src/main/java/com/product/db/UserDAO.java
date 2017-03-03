package com.product.db;

import com.product.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class UserDAO extends AbstractDAO<User> {


    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public User findById(Long id) {
        return get(id);
    }

    public long create(User user) {
        return persist(user).getId();
    }

    public List<User> findAll() {
        return list(namedQuery("com.example.helloworld.core.Product.findAll"));
    }




}
