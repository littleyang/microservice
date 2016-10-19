package com.micro.service.oauth;

import com.micro.service.oauth.model.user.Authority;
import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.repository.jpa.AuthorityJpaRespo;
import com.micro.service.oauth.repository.jpa.UserJpaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthCenterApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private AuthorityJpaRespo authorityJpaRespo;

	@Test
	public  void testgetUserByUserName(){
	  	String username = "admin";
		User user = userJpaRepository.findByUsername(username);
		System.out.print(user.getFullname());
	}

	@Test
	public void testGetAuthorityByName(){
		String name = "ROLE_ADMIN";
		Authority authority = authorityJpaRespo.findAuthorityByName(name);
		Assert.assertEquals("authority name should be equal",name,authority.getName());

	}
}
