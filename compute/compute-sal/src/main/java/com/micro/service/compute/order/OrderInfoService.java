package com.micro.service.compute.order;

import com.micro.service.order.api.OrderFacadeClient;
import com.micro.service.order.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 1:20 PM
 */

@Service
public class OrderInfoService {

    @Autowired
    private OrderFacadeClient orderFacadeClient;

    public List<OrderDto> getAllOrders(){
        return  orderFacadeClient.getOrders();
    }

    public OrderDto getOrderById(int id){
        return orderFacadeClient.getOrderById(id);
    }
}
