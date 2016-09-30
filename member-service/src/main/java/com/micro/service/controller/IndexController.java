package com.micro.service.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 3:17 PM
 */

@RefreshScope
@RestController
@RequestMapping("/index")
public class IndexController {

    private final Logger logger = Logger.getLogger(getClass());

    @Value("${message}")
    private String message;


    @RequestMapping("/message")
    public String indexMessage(){
        return this.message;
    }
}
