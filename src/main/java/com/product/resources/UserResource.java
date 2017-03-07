package com.product.resources;

import com.product.data.repository.UserDAO;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
public class UserResource {

    UserDAO userDao;

    public UserResource(UserDAO userDao) {
        this.userDao=userDao;
    }
}
