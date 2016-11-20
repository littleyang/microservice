package com.micro.service.dao.order;

import com.micro.service.model.order.Order;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-18 11:21 PM
 */

public interface OrderDao {

    public Order getOrderById(int id);

    public int saveOrder(Order order);

    public int saveOrderAndSelect(Order order);

    public Order updateOrder(Order order);

    public void deleteOrderById(int id);

    public void softDeleteOrder(Order order);

    public List<Order> getAllOrdersList();

    public List<Order> getMemberOrdersByMemberId(int memberId);

}
