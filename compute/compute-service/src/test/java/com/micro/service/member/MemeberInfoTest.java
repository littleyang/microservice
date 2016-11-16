package com.micro.service.member;

import com.micro.service.member.service.MemberInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-16 2:05 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class MemeberInfoTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MemberInfoService memberInfoService;


    @Test
    public void testGetAllmemberInfo(){

        System.out.println(memberInfoService.getAllMembers());
    }
}
