package com.micro.service.repository.mapper;

import com.micro.service.model.order.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-18 11:25 PM
 */

@Mapper
public interface OrderMapper {

    public Order getOrderById(long id);

    public Order saveOrder(Order order);

    public Order updateOrder(Order order);

    public void deleteOrder(Order order);

    public List<Order> getAllOrders();
}

