package com.micro.service.oauth.service.user.impl;

import com.micro.service.oauth.dao.UserDao;
import com.micro.service.oauth.model.dto.UserJsonDto;
import com.micro.service.oauth.model.user.AuthUser;
import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.security.WdcyUserDetails;
import com.micro.service.oauth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:44 PM
 */

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUserName(username);
        Set<Authority> userAuths = userDao.findUserAuthoritesByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }

        // 用默认的spring oauth的user实现方式
//        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Authority authority : userAuths) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
//            grantedAuthorities.add(grantedAuthority);
//        }
//        return new AuthUser(user.getUsername(), user.getPassword(), grantedAuthorities);



        // 自定义user的实现方式
        return new WdcyUserDetails(user,userAuths);
    }

    /**
     * 读取所有人信息
     * @return
     */
    @Override
    public List<UserJsonDto> findAllUser() {
        return UserJsonDto.UserListJsonDto(userDao.findAllUsers());
        //return UserJsonDto.UserListJsonDto(userDao.findAllUsersByJpa());
    }

    @Override
    public User getCurrentUserByUserName(String username) {
        //return userDao.getUserByUserName(username);
        return userDao.getUserByUserNameByJpa(username);
    }
}


