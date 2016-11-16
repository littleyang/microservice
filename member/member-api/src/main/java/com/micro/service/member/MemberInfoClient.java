package com.micro.service.member;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-16 1:52 PM
 */

@FeignClient("member")
@Component
public interface MemberInfoClient {

    String SERVICE_NAME = "member";

    String GET_ALL_MEMBERS_URL = "/index/users/all" ;

    String GET_MEMBER_BY_ID_URL = "/member/{id}";

    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = GET_ALL_MEMBERS_URL)
    public String getAllMembers();



}
