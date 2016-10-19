package com.micro.service.oauth.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-19 1:21 PM
 */

public class AuthUser extends User{

    public AuthUser(String username, String password,
                    Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);
    }
}
