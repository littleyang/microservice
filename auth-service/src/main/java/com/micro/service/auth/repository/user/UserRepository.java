package com.micro.service.auth.repository.user;

import com.micro.service.auth.model.user.User;
import com.micro.service.auth.repository.BaseRepository;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 5:52 PM
 */

public interface UserRepository extends BaseRepository{

    User findByGuid(String guid);

    void saveUser(User user);

    void updateUser(User user);

    User findByUsername(String username);

    List<User> findUsersByUsername(String username);

}
