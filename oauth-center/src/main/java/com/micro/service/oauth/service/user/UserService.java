package com.micro.service.oauth.service.user;

import com.micro.service.oauth.model.dto.UserJsonDto;
import com.micro.service.oauth.model.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:44 PM
 */

public interface UserService extends UserDetailsService{

    /**
     *
     * @return
     */
    public List<UserJsonDto> findAllUser();


    /**
     *
     * @param username
     * @return
     */
    public User getCurrentUserByUserName(String username);
}
