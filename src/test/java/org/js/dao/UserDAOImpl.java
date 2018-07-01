package org.js.dao;

import org.js.model.User;

/**
 * Created by JiaShun on 2018/7/1.
 */

public class UserDAOImpl implements UserDAO{
    public void save(User vo){
        System.out.println("user saved !");
    }
}
