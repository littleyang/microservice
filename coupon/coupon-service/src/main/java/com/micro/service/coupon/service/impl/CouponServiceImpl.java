package com.micro.service.coupon.service.impl;

import com.micro.service.coupon.dao.CouponDao;
import com.micro.service.coupon.dto.CouponDto;
import com.micro.service.coupon.service.CouponService;
import com.micro.service.coupon.util.BaseConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-12-14 3:02 PM
 */

@Service
public class CouponServiceImpl implements CouponService {


    @Autowired
    private CouponDao couponDao;


    @Override
    public CouponDto getCouponById(Integer id) {
        return BaseConvertor.convert(couponDao.getCouponById(id),CouponDto.class);
    }
}
