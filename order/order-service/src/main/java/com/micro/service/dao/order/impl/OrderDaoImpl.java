package com.micro.service.dao.order.impl;

import com.micro.service.dao.order.OrderDao;

import com.micro.service.model.order.Order;
import com.micro.service.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-19 9:12 AM
 */

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveOrder(Order order) {
        return orderMapper.insert(order);
    }

    public int saveOrderAndSelect(Order order){
        return orderMapper.insertAndSelectId(order);
    }

    @Override
    public Order updateOrder(Order order) {
        int result = orderMapper.updateByPrimaryKeyWithBLOBs(order);
        return orderMapper.selectByPrimaryKey(order.getId());
    }

    @Override
    public void deleteOrderById(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void softDeleteOrder(Order order) {
      orderMapper.deleteOrderByIdSofted(order);
    }

    @Override
    public List<Order> getAllOrdersList() {
        return orderMapper.getAllOrders();
    }

    @Override
    public List<Order> getMemberOrdersByMemberId(int memberId) {
        return orderMapper.getMemberOrdersByMemberId(memberId);
    }

}
