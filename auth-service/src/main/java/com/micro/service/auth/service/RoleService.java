package com.micro.service.auth.service;

import com.micro.service.auth.model.Role;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:37 PM
 */

public interface RoleService {

    Role findById(Long id);

    Role findByCode(String code);
}
