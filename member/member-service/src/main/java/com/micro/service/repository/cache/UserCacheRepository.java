package com.micro.service.repository.cache;

import com.micro.service.constant.MemberCacaheConstant;
import com.micro.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2017-01-17 2:41 PM
 */

@Repository
public class UserCacheRepository {

    @Autowired
    private RedisTemplate<?,?> redisTemplate;

//    @Autowired
//    private RedisCacheManager redisCacheManager;


    /**
     * 通过account读取缓存里面的用户信息
     * @param user
     * @return
     */
    public User getUser(User user){
        return (User)redisTemplate.opsForValue().get(MemberCacaheConstant.MICRO_SERVICE_MEMEBERS_USER_CACHE_PREFIX
                + user.getAccount());
    }

}
