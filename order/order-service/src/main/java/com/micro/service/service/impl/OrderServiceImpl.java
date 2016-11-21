package com.micro.service.service.impl;

import com.micro.service.dao.order.OrderDao;
import com.micro.service.model.order.Order;
import com.micro.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-19 9:11 AM
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int createOrder(Order order) {
        if(null==order)
            return -1;
        else
            return orderDao.saveOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public void softDeleteOrderById(int id) {
        Order temp = orderDao.getOrderById(id);
        orderDao.softDeleteOrder(temp);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrdersList();
    }

    @Override
    public List<Order> getMemberOrdersByMemberId(int memberId) {
        return orderDao.getMemberOrdersByMemberId(memberId);
    }
}
