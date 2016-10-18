package com.micro.service.oauth.repository.jdbc.impl;

import com.micro.service.oauth.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.oauth.repository.base.RepositoryJdbcBase;
import com.micro.service.oauth.repository.jdbc.mapper.UserRowMapper;
import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 10:19 AM
 * 读取user相关信息
 */

@Repository
public class UserRepositoryJdbcImpl extends RepositoryJdbcBase implements UserRepositoryJdbc {


    private static UserRowMapper userRowMapper = new UserRowMapper();

    /**
     * 获取用户所有的权限
     * @param username
     * @return
     */
    private Set<Authority> findPrivileges(String username) {

        final String sql = " select authority from user_authority where username = ? ";
        final List<Authority> authorities = jdbcTemplate.queryForList(sql, new Object[]{username}, Authority.class);

        Set<Authority> privileges = new HashSet<Authority>(authorities);
        return privileges;
    }


    /**
     * 用username获取用户信息
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        final String sql = " select * from user where username = ? and archived = 0 ";
        final List<User> list = jdbcTemplate.query(sql, new Object[]{username}, userRowMapper);
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
            user.setAuthorities(findPrivileges(user.getUsername()));
        }
        return user;
    }

    /**
     * email获取用户信息
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        final String sql = " select * from user where email = ? and archived = 0 ";
        final List<User> list = jdbcTemplate.query(sql, new Object[]{email}, userRowMapper);
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
            user.setAuthorities(findPrivileges(user.getUsername()));
        }
        return user;
    }


    @Override
    public List<User> findAllUsers() {
        final String sql = " select * from user where archived = 0 ";
        return jdbcTemplate.query(sql,userRowMapper);
    }
}
