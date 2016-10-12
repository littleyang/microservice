package com.micro.service.auth.dao;

import com.micro.service.auth.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:33 PM
 */

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // Todo add the custom search query
}