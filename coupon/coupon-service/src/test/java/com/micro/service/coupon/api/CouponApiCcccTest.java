package com.micro.service.coupon.api;

import com.micro.service.coupon.CouponServiceApplicationTests;
import org.junit.Test;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-15 6:19 PM
 */

public class CouponApiCcccTest extends CouponServiceApplicationTests {


    private CouponApiCccc cccc = new CouponApiCccc();

    @Test
    public void testApiCccTest(){
        String username = "wangdu";
        System.out.println(cccc.hello(username));
    }


}
