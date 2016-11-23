package com.micro.service.order.api;

import com.micro.service.order.dto.OrderDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 10:57 AM
 */

@FeignClient("order")
@Component
public interface OrderFacadeClient {

    String GET_ORDER_BY_ID_REST = "/rest/orders/{id}";

    String GET_ORDERS = "/orders";

    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = GET_ORDER_BY_ID_REST)
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public OrderDto getOrderById(@PathVariable("id") int id);


    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = GET_ORDERS)
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public List<OrderDto> getOrders();

}
