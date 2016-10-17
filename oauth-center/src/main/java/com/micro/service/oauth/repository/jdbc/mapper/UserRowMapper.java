package com.micro.service.oauth.repository.jdbc.mapper;

import com.micro.service.oauth.model.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 10:21 AM
 */

public class UserRowMapper implements RowMapper<User> {


    public UserRowMapper() {
    }

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setGuid(rs.getString("guid"));

        user.setPassword(rs.getString("password"));
        user.setUsername(rs.getString("username"));

        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setMobile(rs.getString("mobile"));

        user.setArchived(rs.getBoolean("archived"));
        user.setCreated(rs.getTimestamp("created").toLocalDateTime());
        user.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
        user.setLastLoginTime(rs.getTimestamp("last_login_time"));

        return user;
    }
}
