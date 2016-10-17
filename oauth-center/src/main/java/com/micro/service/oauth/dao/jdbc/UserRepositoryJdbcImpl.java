package com.micro.service.oauth.dao.jdbc;

import com.micro.service.oauth.dao.UserRepositoryJdbc;
import com.micro.service.oauth.model.mapper.UserRowMapper;
import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class UserRepositoryJdbcImpl implements UserRepositoryJdbc {


    private static UserRowMapper userRowMapper = new UserRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private Set<Authority> findPrivileges(String username) {

        final String sql = " select authority from user_authority where username = ? ";
        final List<Authority> authorities = this.jdbcTemplate.queryForList(sql, new Object[]{username}, Authority.class);

        Set<Authority> privileges = new HashSet<Authority>(authorities);
        return privileges;
    }


    @Override
    public User findByUsername(String username) {
        final String sql = " select * from user where username = ? and archived = 0 ";
        final List<User> list = this.jdbcTemplate.query(sql, new Object[]{username}, userRowMapper);
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
            user.setAuthorities(findPrivileges(user.getUsername()));
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        final String sql = " select * from user where email = ? and archived = 0 ";
        final List<User> list = this.jdbcTemplate.query(sql, new Object[]{email}, userRowMapper);
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
            user.setAuthorities(findPrivileges(user.getUsername()));
        }
        return user;
    }
}
