package com.micro.service.coupon.dao.impl;

import com.micro.service.coupon.dao.CouponDao;
import com.micro.service.coupon.model.Coupon;
import com.micro.service.coupon.repository.jdbc.CouponRepositoryJdbc;
import com.micro.service.coupon.repository.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-12-14 2:55 PM
 */

@Repository
public class CouponDaoImpl implements CouponDao {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponRepositoryJdbc couponRepositoryJdbc;

    @Override
    public Coupon getCouponById(Integer id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Coupon> getAllAviableCoupons() {
        return couponMapper.getAllAviableCoupons();
    }
}
