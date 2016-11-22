package com.micro.service.api.order;

import com.micro.service.member.MemberInfoClient;
import com.micro.service.order.api.OrderFacadeClient;
import com.micro.service.order.dto.OrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Member;
import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 11:12 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class OrderApiTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private OrderFacadeClient orderFacadeClient;

    @Autowired
    private MemberInfoClient memberInfoClient;

    @Test
    public void testOrderApiGetOrderById(){
        int  orderId = 13;
        String orderDto =  orderFacadeClient.getOrderById(orderId);
        System.out.println(orderDto);
    }

    @Test
    public void testOrderApiGetOrders(){
        String orderDto =  orderFacadeClient.getOrders();
        System.out.println(orderDto);
    }

    @Test
    public void testGetAllMemeberInfo(){
        System.out.println(memberInfoClient.getAllMembers());
    }
}
