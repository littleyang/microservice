package com.micro.service.oauth.controller;

import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-18 4:41 PM
 */

public class BaseController {

    protected final Logger log = Logger.getLogger(getClass());

    @Autowired
    protected UserService userService;


    public User getCurrentUser(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        log.debug("getCurrentUser ==== " + username);
        User currentUser = userService.getCurrentUserByUserName(username);
        return currentUser;
    }

}
