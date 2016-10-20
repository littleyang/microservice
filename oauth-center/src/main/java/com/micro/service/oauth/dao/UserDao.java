package com.micro.service.oauth.dao;

import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.oauth.repository.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

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

    /**
     * 用JPA的方式读取user
     * @param username
     * @return
     */
    public User getUserByUserNameByJpa(String username){
        User user = userJpaRepository.findByUsername(username);
        return user;
    }

    /**
     *
     * @param email
     * @return
     */
    public User getUserByEmail(String email){
        return userRepositoryJdbc.findByEmail(email);
    }

    /**
     *
     * @return
     */
    public List<User> findAllUsers(){
        return  userRepositoryJdbc.findAllUsers();
    }

    /**
     *
     * @param username
     * @return
     */
    public Set<Authority> findUserAuthoritesByUserName(String username){
        return  userRepositoryJdbc.findPrivileges(username);
    }

}
