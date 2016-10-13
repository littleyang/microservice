package com.micro.service.auth.constant;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 5:00 PM
 */

public abstract class CacheConstants {

    /**
     * client Details Cache, key is clientId
     */
    public static final String CLIENT_DETAILS_CACHE = "clientDetailsCache";

    /**
     * access Token Cache, key is token
     */
    public static final String ACCESS_TOKEN_CACHE = "accessTokenCache";

    /**
     * refresh Token Cache, key is token
     */
    public static final String REFRESH_TOKEN_CACHE = "refreshTokenCache";

    /**
     * authorization Code Cache, key is code
     */
    public static final String AUTHORIZATION_CODE_CACHE = "authorizationCodeCache";

    /**
     * user Cache, key is username
     */
    public static final String USER_CACHE = "userCache";


    private CacheConstants() {
    }

}
