package com.micro.service.web;

import com.micro.service.compute.order.OrderInfoService;
import com.micro.service.member.consumer.MemberClient;
import com.micro.service.order.dto.OrderDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Member;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/compute")
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Value("${message}")
    private String message;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberClient memberClient;

    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    @RequestMapping("/message")
    public String computeMessage(){
        return this.message;
    }


    @HystrixCommand(fallbackMethod = "addServiceFallback")
    @RequestMapping("/members/all")
    public String getAllMembers(){

        return restTemplate.getForEntity("http://MEMBER/users/all",String.class).getBody();
    }

    @RequestMapping("/users/all")
    public String getAllUsers(){
         logger.info("get all users!!!!!!");
         return this.memberClient.getAllUsers();
     }

    @RequestMapping("/orders/all")
    @ResponseBody
    public List<OrderDto> getAllOrders(){

       // return restTemplate.getForEntity("http://ORDER/orders",String.class).getBody();
        return orderInfoService.getAllOrders();
    }

    @RequestMapping("/orders/{id}")
    @ResponseBody
    public OrderDto getAllOrderById(@PathVariable("id") int id){

        // return restTemplate.getForEntity("http://ORDER/orders",String.class).getBody();
        return orderInfoService.getOrderById(id);
    }


    public String addServiceFallback() {
        return "error";
    }

}