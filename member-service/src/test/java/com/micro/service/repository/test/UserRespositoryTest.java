package com.micro.service.repository.test;

import com.micro.service.model.User;
import com.micro.service.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-10 1:47 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRespositoryTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUserByAccount(){

        String account = "test-001";

        User userTemp = userRepository.findByAccount(account);

        System.out.println("==============" + userTemp.getAccount());

        Assert.assertNotNull(userTemp);
        Assert.assertEquals("account should be equal : test-001 ",userTemp.getAccount(),account);

    }
}
