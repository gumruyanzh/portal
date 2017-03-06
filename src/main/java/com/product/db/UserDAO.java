package com.product.db;

import com.product.core.User;
import com.scottescue.dropwizard.entitymanager.UnitOfWork;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class UserDAO {

    EntityManager em;

    public UserDAO(EntityManager em) {
        this.em=em;
    }

    @UnitOfWork(transactional = false)
    public User findById(Long id) {

        return em.find(User.class, id);
    }

    @UnitOfWork
    public long create(User user) {

        em.persist(user);
        em.flush();
        return user.getId();
    }

    @UnitOfWork(transactional = false)
    public List<User> findAll() {
        return em.createQuery("select u from User u").getResultList();
    }




}
