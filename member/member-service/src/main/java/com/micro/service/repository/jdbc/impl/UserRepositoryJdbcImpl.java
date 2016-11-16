package com.micro.service.repository.jdbc.impl;

import com.micro.service.model.User;
import com.micro.service.repository.base.RepositoryJdbcBase;
import com.micro.service.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.repository.jdbc.mapper.UserRowMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-11 1:59 PM
 */

@Repository
public class UserRepositoryJdbcImpl extends RepositoryJdbcBase implements UserRepositoryJdbc {

    protected final Logger log = Logger.getLogger(getClass());


    private static UserRowMapper userRowMapper = new UserRowMapper();


    @Override
    public User findUserByAccount(String account) {
        final String sql = " select * from user where archived = 0 and account = ?";
        log.debug("findByUsername " + account + sql);
        final List<User> list = jdbcTemplate.query(sql, new Object[]{account}, userRowMapper);
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        final String sql = " select * from user where archived = 0 ";
        return jdbcTemplate.query(sql,userRowMapper);
    }

    @Override
    public User findUserByEmail(String email) {
        final String sql = " select * from user where archived = 0 and email = ? ";
        final List<User> list = jdbcTemplate.query(sql, new Object[]{email}, userRowMapper);
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
        }
        return user;
    }
}
