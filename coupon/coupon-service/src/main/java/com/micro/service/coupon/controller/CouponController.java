package com.micro.service.coupon.controller;

import com.micro.service.coupon.dto.CouponDto;
import com.micro.service.coupon.service.CouponService;
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
 * @since: 2016-12-14 3:03 PM
 */

@RestController
@RequestMapping(value = "/coupon",produces = MediaType.APPLICATION_JSON_VALUE)
public class CouponController {

    @Autowired
    private CouponService couponService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String couponIndex(){
        return "hello, world!!!";
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CouponDto> getCouponById(@PathVariable("id") int id){
        CouponDto result = couponService.getCouponById(id);
        if(null!=result){
            return new ResponseEntity(result, HttpStatus.OK);
        }else{
            return new ResponseEntity(null, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity<List<CouponDto>> getAllAviableCoupons(){
        List<CouponDto> results = couponService.getAllAvaiableCoupons();
        if(results.size()>0){
            return new ResponseEntity(results, HttpStatus.OK);
        }else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
