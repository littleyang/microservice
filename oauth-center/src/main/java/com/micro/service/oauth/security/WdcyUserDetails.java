package com.micro.service.oauth.security;

import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:58 PM
 */

public class WdcyUserDetails implements UserDetails {

        private static final long serialVersionUID = 3957586021470480642L;

        private String username;

        private String password;

        protected User oauthUser;

        protected List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        public WdcyUserDetails() {
        }

        public WdcyUserDetails(User tempUser) {
            this.oauthUser = tempUser;
            this.username = tempUser.getUsername();
            this.password = tempUser.getPassword();
            initialAuthorities();
        }

        private void initialAuthorities() {
//            //Default, everyone have it
//            this.grantedAuthorities.add(DEFAULT_USER_ROLE);
//            //default user have all privileges
//            if (user.defaultUser()) {
//                this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + Privilege.UNITY.name()));
//                this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + Privilege.MOBILE.name()));
//            } else {
//                final List<Privilege> privileges = user.privileges();
//                for (Privilege privilege : privileges) {
//                    this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + privilege.name()));
//                }
//            }

            for (Authority authority : oauthUser.getAuthorities()) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        /**
         * Return authorities, more information see {@link #initialAuthorities()}
         *
         * @return Collection of GrantedAuthority
         */
        @Override
        public Collection<GrantedAuthority> getAuthorities() {
            return this.grantedAuthorities;
        }

        @Override
        public String getPassword() {
            return this.password;
        }

        @Override
        public String getUsername() {
            return this.username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public User user() {
            return oauthUser;
        }


        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("{user=").append(oauthUser);
            sb.append('}');
            return sb.toString();
        }
}
