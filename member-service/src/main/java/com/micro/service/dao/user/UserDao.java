package com.micro.service.dao.user;

import com.micro.service.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.repository.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-11 2:06 PM
 */

@Component
public class UserDao {

    @Autowired
    private UserRepositoryJdbc userRepositoryJdbc;

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;



}
