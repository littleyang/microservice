//package com.micro.service.auth.config;
//
///**
// * @description:
// * @author: yang.zhou
// * @version: 1.0.0
// * @since: 2016-10-12 7:44 PM
// */
//
//import com.micro.service.auth.dao.AccountRepository;
//import com.micro.service.auth.model.Account;
//import com.micro.service.auth.model.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final AccountRepository userRepository;
//
//    @Autowired
//    public CustomUserDetailsService(AccountRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Account account = userRepository.findByUsername(username);
//
//        if (account == null) {
//            // Not found...
//            throw new UsernameNotFoundException(
//                    "User " + username + " not found.");
//        }
//
//        if (account.getRoles() == null || account.getRoles().isEmpty()) {
//            // No Roles assigned to user...
//            throw new UsernameNotFoundException("User not authorized.");
//        }
//
//
//        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//        for (Role role : account.getRoles()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
//        }
//
//        User userDetails = new User(account.getUsername(),
//                account.getPassword(), account.isEnabled(),
//                !account.isExpired(), !account.isCredentialsexpired(),
//                !account.isLocked(), grantedAuthorities);
//
//        return userDetails;
//    }
//
//    private final static class UserRepositoryUserDetails extends Account implements UserDetails {
//
//        private static final long serialVersionUID = 1L;
//
//
//
//        private UserRepositoryUserDetails(Account user) {
//            super(user);
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//            for (Role role : getRoles()) {
//                grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
//            }
//            return grantedAuthorities;
//        }
//
//        @Override
//        public String getUsername() {
//            return getUsername();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return !isExpired();
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return !isLocked();
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return !isCredentialsexpired();
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return isEnabled();
//        }
//
//        @Override
//        public Set<Role> getRoles() {
//            return getRoles();
//        }
//    }
//}