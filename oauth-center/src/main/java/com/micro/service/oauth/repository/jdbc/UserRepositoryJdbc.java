package com.micro.service.oauth.repository.jdbc;

import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;

import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 10:46 AM
 */

public interface UserRepositoryJdbc {

    /**
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);

    /**
     *
     * @return
     */
    public List<User> findAllUsers();


    public Set<Authority> findPrivileges(String username);

}
