package com.micro.service.oauth.Interceptor;

import com.micro.service.oauth.filter.RequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-18 3:11 PM
 */

@Component
public class AccessTokenVerifyInterceptor  extends HandlerInterceptorAdapter {


    private final Logger log = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 可以做更多的业务逻辑
        String authorization = request.getHeader("Authorization");
        log.debug("Authorization ==== " + authorization);
        String accessToken = "";
        if(!"".equals(authorization)){
            // 拿到token
            accessToken = authorization.split(" ")[1];
        }
        log.debug("accessToken ==== " + accessToken);
        return super.preHandle(request, response, handler);
    }
}
