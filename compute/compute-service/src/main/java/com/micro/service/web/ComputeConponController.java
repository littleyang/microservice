package com.micro.service.web;

import com.micro.service.compute.coupon.ComputeCouponService;
import com.micro.service.coupon.dto.CouponDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2017-01-18 4:08 PM
 */

@RefreshScope
@RestController
@RequestMapping(value = "/compute/coupon",produces = MediaType.APPLICATION_JSON_VALUE)
public class ComputeConponController {

    @Autowired
    private ComputeCouponService computeCouponService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<CouponDto> getCouponById(@PathVariable int id){
        CouponDto couponDto = computeCouponService.getCouponById(id);
        if(null!=couponDto){
            return new ResponseEntity(couponDto, HttpStatus.OK);
        }else{
            return new ResponseEntity(couponDto, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity<List<CouponDto>> getAllCoupons(){
        List<CouponDto> lists = computeCouponService.getAllAvaiableCoupons();
        if(lists.size()>0){
            return new ResponseEntity(lists, HttpStatus.OK);
        }else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
