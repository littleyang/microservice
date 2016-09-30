package com.micro.service.repository;

import com.micro.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 4:46 PM
 */

@Component
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByAccount(@Param("account") String account);



}
