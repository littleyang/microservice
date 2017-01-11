package com.micro.service.order;

import com.micro.service.dao.order.OrderDao;
import com.micro.service.model.order.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-19 1:56 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;


    @Test
    public void testCreateOrder(){
        Order order = new Order();
        order.setName("买个蜂蜜试试");
        order.setDescription("仅仅只是一个测试用例而已，不要太在意！");
        order.setCountry("美国");
        order.setAddress("test address");
        int result = orderDao.saveOrder(order);
        System.out.println("create result is  " + result);
        Assert.assertTrue("if create success, the result should > 0",result>0);

    }

    @Test
    public void updateOrder(){
        Order temp = orderDao.getOrderById(13);
        Assert.assertEquals("temp order address should be equal","test address",temp.getAddress());
        Assert.assertTrue("member id should == 100001",temp.getMemberId()==100001);

        //update order
        temp.setName("test update order name" + System.currentTimeMillis());
        Order tempUpdated = orderDao.updateOrder(temp);
        Assert.assertEquals("temp order name should be equal",temp.getName(),tempUpdated.getName());

    }

    @Test
    public void testSoftDeleteOrder(){

        Order order = new Order();
        order.setName("买个蜂蜜试试");
        order.setDescription("仅仅只是一个测试用例而已，不要太在意！");
        order.setCountry("美国");
        order.setAddress("test address");
        int result = orderDao.saveOrderAndSelect(order);
        System.out.println(order.getId());
        Assert.assertTrue("insert should be success " ,result>0);

        Order temp = orderDao.getOrderById(order.getId());
        Assert.assertNotNull(temp);

        // soft delete
        orderDao.softDeleteOrder(temp);
        Order tempDeleted = orderDao.getOrderById(temp.getId());
        Assert.assertNull(tempDeleted);

    }

    @Test
    public void testGetListOrder(){

        List<Order> testList = orderDao.getAllOrdersList();
        System.out.println(" testList.size() " + testList.size());
        Assert.assertTrue("order list should not null ", testList.size()>0);

    }

    @Test
    public void testGetMemberOrders(){
        int memberId = 100001;
        List<Order> memeberOrders = orderDao.getMemberOrdersByMemberId(memberId);
        System.out.println(memeberOrders.size());
        Assert.assertTrue("member 100001 orders should >0 ", memeberOrders.size()>0);
    }

}
