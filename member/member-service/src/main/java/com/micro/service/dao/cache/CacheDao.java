package com.micro.service.dao.cache;

import com.micro.service.repository.cache.UserCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2017-01-17 2:40 PM
 */

@Component
public class CacheDao {

    @Autowired
    private UserCacheRepository cacheRepository;


}
