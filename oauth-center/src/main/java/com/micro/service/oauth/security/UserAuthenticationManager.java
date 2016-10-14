package com.micro.service.oauth.security;

import com.micro.service.oauth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:28 PM
 */

@Component("userAuthenticationManager")
public class UserAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserService UserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }


}
