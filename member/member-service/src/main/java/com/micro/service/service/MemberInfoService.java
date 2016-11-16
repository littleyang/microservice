package com.micro.service.service;

import com.micro.service.member.MemberInfoClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-16 2:03 PM
 */

@FeignClient(MemberInfoClient.SERVICE_NAME)
@Service
public interface MemberInfoService {

    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = MemberInfoClient.GET_ALL_MEMBERS_URL)
    public String getAllMembers();

}
