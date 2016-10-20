package com.micro.service.oauth.service.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:02 PM
 */

@Component
public class CustomJdbcTokenStore extends JdbcTokenStore {

    @Autowired
    public CustomJdbcTokenStore(DataSource dataSource) {
        super(dataSource);
    }

}
