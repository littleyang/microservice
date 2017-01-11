package com.micro.service.coupon;

import com.micro.service.coupon.dao.CouponDao;
import com.micro.service.coupon.model.Coupon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponServiceApplicationTests {


	@Test
	public void contextLoads() {
	}

	@Autowired
	private CouponDao couponDao;

	@Test
	public void testGetCouponById(){
		Integer id = 1000;
		Coupon couponTest = couponDao.getCouponById(id);
		System.out.println(couponTest.getId());
	}




}
