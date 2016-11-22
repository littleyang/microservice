package com.micro.service.service;

import com.micro.service.order.model.order.Order;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-19 9:10 AM
 */

public interface OrderService {

    public int createOrder(Order order);

    public Order getOrderById(int id);

    public Order updateOrder(Order order);

    public void softDeleteOrderById(int id);

    public List<Order> getAllOrders();

    public List<Order> getMemberOrdersByMemberId(int memberId);

}
