package com.micro.service.auth.service;

import com.micro.service.auth.model.Account;

import java.util.Collection;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:34 PM
 */


public interface AccountService {

    Collection<Account> findAll();

    Account findByUsername(String userename);

    Account createNewAccount(Account account);


}