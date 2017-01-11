package com.micro.service.order;

import com.micro.service.compute.order.OrderInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 1:22 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoServiceTest {

    @Autowired
    private OrderInfoService orderInfoService;

    @Test
    public void testGetAllOrders(){
        System.out.println(orderInfoService.getAllOrders().size());
    }
}
