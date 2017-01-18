package com.micro.service.compute.coupon;

import com.micro.service.coupon.api.CouponFacadeClient;
import com.micro.service.coupon.dto.CouponDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2017-01-18 4:05 PM
 */

@Service
public class ComputeCouponService {

    @Autowired
    public CouponFacadeClient couponFacadeClient;

    /**
     * 通过id获取优惠码
     * @param id
     * @return
     */
    public CouponDto getCouponById(int id){
        return couponFacadeClient.getCouponById(id);
    }

    public List<CouponDto> getAllAvaiableCoupons(){
        return couponFacadeClient.getAllCoupons();
    }


}
