package com.micro.service.coupon.dao;


import com.micro.service.coupon.model.Coupon;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-12-14 2:53 PM
 */

public interface CouponDao {

    public Coupon getCouponById(Integer id);

    public List<Coupon> getAllAviableCoupons();

}
