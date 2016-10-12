package com.micro.service.auth.controller;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:39 PM
 */

import com.micro.service.auth.model.Account;
import com.micro.service.auth.service.AccountService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class ApiController extends BaseController{

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;


    @RequestMapping(value="/api/sample", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> sampleGet(HttpServletResponse response){
         logger.info("/api/sample=================");
        return new ResponseEntity<Account>(accountService.findByUsername("papidakos"), HttpStatus.CREATED);
        //return new ResponseEntity<Account>(new Account(), HttpStatus.CREATED);
    }

    @RequestMapping(value="/api/sample", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> sample(HttpServletResponse response){
        logger.info("/api/sample=================");
        return new ResponseEntity<Account>(accountService.findByUsername("papidakos"), HttpStatus.CREATED);
    }

    /**
     * Create a new user account
     * @param account user account
     * @return created account as json
     */
    @RequestMapping(value="/register", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> register(@Valid @RequestBody Account account, BindingResult errors){


        Account createdAccount = accountService.createNewAccount(account);
        return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
    }

    @RequestMapping(value="/forgot-password", method=RequestMethod.GET)
    public ResponseEntity<String> forgotPassword() throws MessagingException {
        String response = "{success: true}";
        //smtpMailSender.send("cpapidas@gmail.com", "Password forgot", "Forgot password url");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}