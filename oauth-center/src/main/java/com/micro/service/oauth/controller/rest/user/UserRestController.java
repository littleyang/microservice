package com.micro.service.oauth.controller.rest.user;

import com.micro.service.oauth.controller.BaseController;
import com.micro.service.oauth.model.dto.UserJsonDto;
import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-15 9:27 AM
 */

@RestController
@RequestMapping("/api/users")
public class UserRestController extends BaseController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserJsonDto> getAllUsers(HttpServletRequest request){
        User currentUser = getCurrentUser(request);
        List<UserJsonDto> users = userService.findAllUser();
        return users;
    }


    @RequestMapping(value = "/currentdto",method = RequestMethod.GET)
    public UserJsonDto getCurrentLoginUserDto(HttpServletRequest request){
        User currentUser = getCurrentUser(request);
        return new UserJsonDto(currentUser);
    }

    @RequestMapping(value = "/current",method = RequestMethod.GET)
    public User getCurrentLoginUser(HttpServletRequest request){
        User currentUser = getCurrentUser(request);
        return currentUser;
    }

}
