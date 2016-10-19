package com.micro.service.oauth.repository.jpa;

import com.micro.service.oauth.model.user.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-19 1:34 PM
 */

@Component
public interface AuthorityJpaRespo extends CrudRepository<Authority, String> {

    @Query("SELECT a FROM Authority a WHERE LOWER(a.name) = LOWER(:name) ")
    public Authority findAuthorityByName(@Param("name")String name);


}
