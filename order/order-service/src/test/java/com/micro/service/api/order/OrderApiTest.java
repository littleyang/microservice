package com.micro.service.api.order;

import com.micro.service.BootWarApplicationTests;
import com.micro.service.member.MemberInfoClient;
import com.micro.service.order.api.ApiDDDDD;
import com.micro.service.order.api.OrderFacadeClient;
import com.micro.service.order.dto.OrderDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import java.util.List;


/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 11:12 AM
 */
@EnableDiscoveryClient
//@EnableAutoConfiguration
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class OrderApiTest extends BootWarApplicationTests {

    @Autowired
    private MemberInfoClient memberInfoClient;

    @Autowired
    private OrderFacadeClient orderFacadeClient;

    @Test
    public void testMeme(){

        System.out.println(memberInfoClient.getAllMembers());
    }

    @Test
    public  void  testApiDDDDD(){
        String name = "wangdu";
        System.out.println(new ApiDDDDD().syaHello(name));
    }

    @Test
    public  void testGetOrderById(){
        int id = 13;
        OrderDto orderDto = orderFacadeClient.getOrderById(id);
        System.out.println(orderDto.getAddress());
    }

    @Test
    public  void testGetAllOrders(){
        List<OrderDto> orders = orderFacadeClient.getOrders();
        System.out.println(orders.size());
    }

}
