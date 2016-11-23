package com.micro.service.api;

import com.micro.service.base.ApplicationBaseTest;
import com.micro.service.order.api.OrderFacadeClient;
import com.micro.service.service.MemberInfoService;
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
 * @since: 2016-11-16 10:38 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class MemberInfoApiTest{

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private OrderFacadeClient orderFacadeClient;

    @Test
    public void testGetAllMembers(){
        System.out.println(memberInfoService.getAllMemebers());
    }

    @Test
    public void testGetOrderById(){
        System.out.println(orderFacadeClient.getOrderById(13).getAddress());
    }

}
