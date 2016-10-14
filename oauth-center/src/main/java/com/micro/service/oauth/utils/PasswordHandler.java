package com.micro.service.oauth.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 2016/3/25
 * <p/>
 * 处理账号密码, 使用MD5加密
 */
public abstract class PasswordHandler {


    private PasswordHandler() {
    }


    public static String md5(String password) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(password, null);
    }
}
