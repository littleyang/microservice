package com.micro.service.dao.order;

import com.micro.service.model.order.Order;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-18 11:21 PM
 */

public interface OrderDao {

    public Order getOrderById(int id);

    public int saveOrder(Order order);

    public void deleteOrderById(int id);

    public void deleteOrder(Order order);


}
