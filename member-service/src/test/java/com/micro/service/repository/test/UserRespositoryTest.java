package com.micro.service.repository.test;

import com.micro.service.model.User;
import com.micro.service.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

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

    @Test
    public  void testSaveUser(){
        User user = new User();
        user.setAccount("test-user-" + new Random().nextInt());
        user.setFullname("test-user-name");

        User tempUser = userRepository.save(user);

        System.out.println("ddddddd ===== : " + tempUser.getAccount());
        Assert.assertNotNull(tempUser);
        Assert.assertEquals("two user name should be equal : " , user.getAccount(),tempUser.getAccount());

    }

    @Test
    public  void testDeleteUser(){
        User user = new User();
        user.setAccount("test-user-" + new Random().nextInt());
        user.setFullname("test-user-name");

        User tempUser = userRepository.save(user);

        System.out.println("ddddddd ===== : " + tempUser.getAccount());
        Assert.assertNotNull(tempUser);
        Assert.assertEquals("two user name should be equal : " , user.getAccount(),tempUser.getAccount());


        userRepository.delete(tempUser);
        User userAfterDelete = userRepository.findByAccount(tempUser.getAccount());
        Assert.assertNull("user should be null: " ,userAfterDelete);

    }
}