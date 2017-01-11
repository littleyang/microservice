package com.micro.service.coupon;

import com.micro.service.coupon.api.CouponApiCccc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponApiApplicationTests {

	@Test
	public void contextLoads() {
	}

	private CouponApiCccc cccc = new CouponApiCccc();

	@Test
	public void testApiCccTest(){
		String username = "wangdu";
		System.out.println(cccc.hello(username));
	}

}
