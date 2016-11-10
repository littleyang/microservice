package com.micro.service.repository;

import com.micro.service.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 4:46 PM
 */

@Component
@CacheConfig(cacheNames = "members")
public interface UserRepository extends JpaRepository<User,Integer> {

    @Cacheable(key = "'microservice:members:user:'+#account")
    //@Query("from User u where u.account=:account")
    User findByAccount(String account);

    // 更新数据同时更新缓存
    @CachePut(key = "'microservice:members:user'+#user.account")
    User save(User user);

    // 缓存失效
    @CacheEvict(value = "userCacahe",key = "'microservice:members:user'+#user.account")
    void delete(User user);

}
