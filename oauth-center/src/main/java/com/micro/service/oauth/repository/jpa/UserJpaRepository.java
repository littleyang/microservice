package com.micro.service.oauth.repository.jpa;

import com.micro.service.oauth.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 用户对user的ORMapping管理
 * 方便crud操作
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:16 PM
 */


public interface UserJpaRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    public User findByUsernameCaseInsensitive(@Param("username") String username);

    @Query
    public User findByEmail(@Param("email")String email);

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    public User findByUsername(@Param("username")String username);

}