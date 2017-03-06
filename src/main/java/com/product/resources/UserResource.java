package com.product.resources;

import com.product.db.UserDAO;

import javax.persistence.EntityManager;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class UserResource {

    UserDAO userDao;

    public UserResource(UserDAO userDao) {
        this.userDao=userDao;
    }
}
