package com.micro.service.order;

import com.micro.service.dao.order.OrderDao;
import com.micro.service.model.order.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
