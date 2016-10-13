package com.micro.service.auth.repository.jdbc;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;

import javax.sql.DataSource;

import static com.micro.service.auth.utils.CacheConstants.AUTHORIZATION_CODE_CACHE;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 5:59 PM
 */

public class AuthorizationCodeService extends JdbcAuthorizationCodeServices {

    public AuthorizationCodeService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    @Cacheable(value = AUTHORIZATION_CODE_CACHE, key = "#code")
    public void store(String code, OAuth2Authentication authentication) {
        super.store(code, authentication);
    }

    @Override
    @CacheEvict(value = AUTHORIZATION_CODE_CACHE, key = "#code")
    public OAuth2Authentication remove(String code) {
        return super.remove(code);
    }
}
