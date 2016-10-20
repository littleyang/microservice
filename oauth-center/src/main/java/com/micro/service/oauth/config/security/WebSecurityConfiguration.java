package com.micro.service.oauth.config.security;

import com.micro.service.oauth.security.OAuthUserDetailService;
import com.micro.service.oauth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 11:47 AM
 */


@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private OAuthUserDetailService oauthUserDetailService;

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

    }


    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring()
                .antMatchers("/api/register")
                .antMatchers("/api/activate")
                .antMatchers("/api/lostpassword")
                .antMatchers("/api/resetpassword")
                .antMatchers("/api/hello")
                .antMatchers("/open/patrner");

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    @Qualifier("clientCredentialsTokenEndpointFilter")
    public ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter() throws Exception{
        ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter  = new ClientCredentialsTokenEndpointFilter();
        clientCredentialsTokenEndpointFilter.setAuthenticationManager(super.authenticationManager());
        return clientCredentialsTokenEndpointFilter;
    }


}
