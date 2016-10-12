package com.micro.service.auth.controller;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:45 PM
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StarterController {

    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }
}
