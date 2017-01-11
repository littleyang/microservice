package com.micro.service.controller;

import com.micro.service.greeting.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-28 5:21 PM
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){

        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

}
