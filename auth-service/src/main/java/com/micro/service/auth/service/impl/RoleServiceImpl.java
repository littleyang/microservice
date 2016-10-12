package com.micro.service.auth.service.impl;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-12 4:38 PM
 */

import com.micro.service.auth.dao.RoleRepository;
import com.micro.service.auth.model.Role;
import com.micro.service.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoleServiceImpl implements RoleService {


    /**
     * The Spring Data repository for Account entities.
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Get by id
     * @param id
     * @return
     */
    @Override
    public Role findById(Long id) {
        Role role = roleRepository.findOne(id);
        return role;
    }

    /**
     * File Role by code
     * @param code - the code of the role
     * @return Role object
     */
    @Override
    public Role findByCode(String code) {
        return roleRepository.findByCode(code);
    }

}
