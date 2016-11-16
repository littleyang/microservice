package com.micro.service.member.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 5:16 PM
 */

@FeignClient("member")
@Component
public interface MemberClient {

    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = "/index/users/all")
    String getAllUsers();

}
