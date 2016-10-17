package com.micro.service.oauth.dao;

import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.oauth.repository.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:  对user数据访问的同一封装
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 1:06 PM
 */

@Component
public class UserDao {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRepositoryJdbc userRepositoryJdbc;

    /**
     *
     * @param username
     * @return
     */
    public User getUserByUserName(String username){
        return userRepositoryJdbc.findByUsername(username);
    }


    public User getUserByEmail(String email){

        return userRepositoryJdbc.findByEmail(email);

    }


}
