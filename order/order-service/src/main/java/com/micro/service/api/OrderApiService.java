package com.micro.service.api;

import com.micro.service.order.api.OrderFacadeClient;
import com.micro.service.order.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 10:52 PM
 */

@Service
public class OrderApiService {

    @Autowired
    private OrderFacadeClient orderFacadeClient;

    public OrderDto getOrderById(int id){
       return orderFacadeClient.getOrderById(id);
    }
}
