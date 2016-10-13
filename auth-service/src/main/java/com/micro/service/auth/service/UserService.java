package com.micro.service.auth.service;

import com.micro.service.auth.model.dto.UserFormDto;
import com.micro.service.auth.model.dto.UserJsonDto;
import com.micro.service.auth.model.dto.UserOverviewDto;


import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 6:07 PM
 */

public interface UserService extends UserDetailsService{

    UserJsonDto loadCurrentUserJsonDto();

    UserOverviewDto loadUserOverviewDto(UserOverviewDto overviewDto);

    boolean isExistedUsername(String username);

    String saveUser(UserFormDto formDto);
}
