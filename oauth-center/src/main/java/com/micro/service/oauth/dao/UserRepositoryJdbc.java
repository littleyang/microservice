package com.micro.service.oauth.dao;

import com.micro.service.oauth.model.user.User;

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

}
