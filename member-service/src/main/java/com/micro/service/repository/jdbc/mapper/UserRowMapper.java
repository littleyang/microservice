package com.micro.service.repository.jdbc.mapper;

import com.micro.service.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-11 2:18 PM
 */

public class UserRowMapper implements RowMapper<User>{

    public UserRowMapper() {
    }

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setPassword(rs.getString("password"));
        user.setFullname(rs.getString("fullname"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setMobile(rs.getString("mobile"));
        user.setArchived(rs.getBoolean("archived"));
        user.setCreated(rs.getTimestamp("created").toLocalDateTime());
        user.setUpdated(rs.getTimestamp("updated").toLocalDateTime());

        return user;
    }
}
