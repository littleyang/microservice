package com.example;

import com.demo.api.UserApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCoreServiceApplicationTests {

	UserApi userApi = new UserApi();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserApi(){
		String username = "wangdu";
		System.out.println(userApi.testUserAPIOk(username));
	}

}
