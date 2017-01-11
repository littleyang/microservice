package com.micro.service.oauth.controller.rest.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2017-01-11 4:21 PM
 */

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthUserController {

    /**
     * Return the principal identifying the logged in user
     * @param user
     * @return
     */
    @RequestMapping("/me")
    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }
}
