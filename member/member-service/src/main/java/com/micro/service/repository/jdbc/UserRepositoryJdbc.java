package com.micro.service.repository.jdbc;

import com.micro.service.model.User;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-11 1:59 PM
 */

public interface UserRepositoryJdbc {


    public User findUserByAccount(String account);


    public List<User> findAllUsers();


    public User findUserByEmail(String email);

}
