package com.micro.service.service.user;

import com.micro.service.model.User;
import com.micro.service.repository.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 4:49 PM
 */

@Component
public class UserService {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;


    /**
     * create user
     * @param user
     * @return
     */
    public User createUser(User user){

        return userRepositoryJpa.save(user);

    }


    /**
     * find all users
     * @return
     */
    public List<User> findAllUsers(){
        return userRepositoryJpa.findAll();
    }
}
