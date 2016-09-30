package com.micro.service.service;

import com.micro.service.model.User;
import com.micro.service.repository.UserRepository;
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
    private UserRepository userRepository;


    /**
     * create user
     * @param user
     * @return
     */
    public User createUser(User user){

        return userRepository.save(user);

    }


    /**
     * find all users
     * @return
     */
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
