package com.micro.service.auth.controller.unity;

import com.micro.service.auth.model.dto.UserJsonDto;
import com.micro.service.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 6:24 PM
 */

@Controller
@RequestMapping("/unity/")
public class UnityController {


    @Autowired
    private UserService userService;


    @RequestMapping("dashboard")
    public String dashboard() {
        return "unity/dashboard";
    }

    @RequestMapping("user_info")
    @ResponseBody
    public UserJsonDto userInfo() {
        return userService.loadCurrentUserJsonDto();
    }

}
