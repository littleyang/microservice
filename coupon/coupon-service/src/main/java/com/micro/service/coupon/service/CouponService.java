package com.micro.service.coupon.service;

import com.micro.service.coupon.dto.CouponDto;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-12-14 2:44 PM
 */

public interface CouponService {

    public CouponDto getCouponById(Integer id);
}
