package com.micro.service.controller;

import com.micro.service.model.order.Order;
import com.micro.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-19 9:58 PM
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public Order getOrderById(@PathVariable("id") int id){
        return orderService.getOrderById(id);
    }


    @RequestMapping(value = "/orders" , method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/rest/orders/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getOrderByIdRest(@PathVariable("id") int id){
        Order result = null;
        if(id>0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            result = orderService.getOrderById(id);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/rest/orders" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getOrdersRest(){
        List<Order> orders = orderService.getAllOrders();
        if(orders.size()>0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orders, HttpStatus.OK);
    }


}
