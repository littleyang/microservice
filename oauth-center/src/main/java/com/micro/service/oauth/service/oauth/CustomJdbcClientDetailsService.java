package com.micro.service.oauth.service.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 12:59 PM
 */

@Component
public class CustomJdbcClientDetailsService extends JdbcClientDetailsService {

    @Autowired
    public CustomJdbcClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }
}
