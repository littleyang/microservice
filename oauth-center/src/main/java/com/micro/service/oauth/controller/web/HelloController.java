package com.micro.service.oauth.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 5:16 PM
 */

@Controller
public class HelloController {

    @RequestMapping(value = "/api/hello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello User!";
    }

    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    @ResponseBody
    public String sayHellosss() {
        return "Secure Hello!";
    }

}
