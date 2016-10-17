package com.micro.service.oauth.service.user.impl;

import com.micro.service.oauth.dao.UserRepository;
import com.micro.service.oauth.dao.UserRepositoryJdbc;
import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.security.WdcyUserDetails;
import com.micro.service.oauth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:44 PM
 */

@Service("userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserRepositoryJdbc userRepositoryJdbc;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userRepository.findByUsername(username);
        User user = userRepositoryJdbc.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }

        return new WdcyUserDetails(user);
    }
}


