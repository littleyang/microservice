package com.micro.service.compute.member;

import com.micro.service.compute.ComputeSalApplicationTests;
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
 * @since: 2016-11-16 11:01 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class MemberInfoClientTest extends ComputeSalApplicationTests {

    @Autowired
    private ComputeMemberInfoService memberInfoService;

    @Test
    public void testGetAllMembers(){
        System.out.println(memberInfoService.getAllMembers());
    }

}
