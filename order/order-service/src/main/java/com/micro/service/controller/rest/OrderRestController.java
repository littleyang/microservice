package com.micro.service.controller.rest;

import com.micro.service.order.model.order.Order;
import com.micro.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-20 10:16 AM
 */

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/rest/{id}",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderByIdRestddd(@PathVariable("id") int id){
        Order result = orderService.getOrderById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/orders/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderByIdRest(@PathVariable("id") int id){
        Order result = orderService.getOrderById(id);
        if(null==result){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrdersRest(){
        List<Order> orders = orderService.getAllOrders();
        if(orders.size()==0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/member/{id}/orders", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getMemberOrdersRest(@PathVariable("id") int memberId){
        List<Order> orders = orderService.getMemberOrdersByMemberId(memberId);
        if(orders.size()==0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orders, HttpStatus.OK);
    }

}
