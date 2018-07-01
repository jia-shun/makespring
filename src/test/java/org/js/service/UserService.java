package org.js.service;

import org.js.dao.UserDAO;
import org.js.model.User;

/**
 * Created by JiaShun on 2018/7/1.
 */

public class UserService {

    private UserDAO userDAO ;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User user){
        this.userDAO.save(user);
    }
}
