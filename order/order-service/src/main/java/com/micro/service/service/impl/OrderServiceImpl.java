package com.micro.service.service.impl;

import com.micro.service.dao.order.OrderDao;
import com.micro.service.model.order.Order;
import com.micro.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
