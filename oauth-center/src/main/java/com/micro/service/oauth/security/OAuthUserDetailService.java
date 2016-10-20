package com.micro.service.oauth.security;



import com.micro.service.oauth.repository.jdbc.UserRepositoryJdbc;
import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:51 PM
 */

@Component("oauthUserDetailService")
public class OAuthUserDetailService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

//    @Autowired
//    private UserJpaRepository userRepository;

    @Autowired
    private UserRepositoryJdbc userRepositoryJdbc;

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        log.debug("Authenticating {}", login);

        String lowercaseLogin = login.toLowerCase();

        User userFromDatabase = userRepositoryJdbc.findByUsername(lowercaseLogin);
        Set<Authority> userAuths = userRepositoryJdbc.findPrivileges(lowercaseLogin);

        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        } else if (!userFromDatabase.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " is not activated");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : userAuths) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(userFromDatabase.getUsername(), userFromDatabase.getPassword(), grantedAuthorities);
    }

}
