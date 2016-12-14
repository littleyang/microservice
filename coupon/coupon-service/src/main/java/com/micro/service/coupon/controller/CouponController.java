package com.micro.service.coupon.controller;

import com.micro.service.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-12-14 3:03 PM
 */

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;




}
