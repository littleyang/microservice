package com.micro.service.auth.model.dto;

import com.micro.service.auth.model.user.Privilege;
import com.micro.service.auth.model.user.User;
import com.micro.service.auth.utils.PasswordHandler;

/**
 * 2016/3/25
 */
public class UserFormDto extends UserDto {
    private static final long serialVersionUID = 7959857016962260738L;


    private String password;

    public UserFormDto() {
    }


    public Privilege[] getAllPrivileges() {
        return new Privilege[]{Privilege.MOBILE, Privilege.UNITY};
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User newUser() {
        final User user = new User()
                .username(getUsername())
                .phone(getPhone())
                .email(getEmail())
                .password(PasswordHandler.md5(getPassword()));
        user.privileges().addAll(getPrivileges());
        return user;
    }
}
