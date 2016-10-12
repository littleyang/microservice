package com.micro.service.auth.service.impl;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:35 PM
 */

import com.micro.service.auth.dao.AccountRepository;
import com.micro.service.auth.model.Account;
import com.micro.service.auth.model.Role;
import com.micro.service.auth.service.AccountService;
import com.micro.service.auth.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

    /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The Spring Data repository for Account entities.
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * The Spring Data repository for Role entities
     */
    @Autowired
    private RoleService roleService;

    /**
     * Find and return all accounts
     * @return collection of all accounts
     */
    @Override
    public Collection<Account> findAll() {
        Collection<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    /**
     * Find user by username
     * @param username the username of the user
     * @return the user account
     */
    @Override
    public Account findByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return account;
    }

    /**
     * Create a new user as simple user. Find the simple user role from the database
     * add assign to the many to many collection
     * @param account - new Account of user
     * @return - the created account
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Account createNewAccount(Account account) {

        // Add the simple user role
        Role role = roleService.findByCode("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        // Validate the password
        if (account.getPassword().length() < 8){
            throw new EntityExistsException("password should be greater than 8 characters");
        }

        // Encode the password
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

        // Create the role
        account.setRoles(roles);
        return accountRepository.save(account);
    }
}
