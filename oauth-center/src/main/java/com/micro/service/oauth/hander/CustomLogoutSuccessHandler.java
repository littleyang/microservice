//package com.micro.service.oauth.hander;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @description:
// * @author: yang.zhou
// * @version: 1.0.0
// * @since: 2016-10-14 12:52 PM
// */
//
//@Component
//public class CustomLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
//        implements LogoutSuccessHandler {
//
//
//    private static final String BEARER_AUTHENTICATION = "Bearer ";
//    private static final String HEADER_AUTHORIZATION = "authorization";
//
//    @Autowired
//    @Qualifier("customJdbcTokenStore")
//    private TokenStore tokenStore;
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request,
//                                HttpServletResponse response,
//                                Authentication authentication)
//            throws IOException, ServletException {
//
//        String token = request.getHeader(HEADER_AUTHORIZATION);
//
//        if (token != null && token.startsWith(BEARER_AUTHENTICATION)) {
//
//            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[0]);
//
//            if (oAuth2AccessToken != null) {
//                tokenStore.removeAccessToken(oAuth2AccessToken);
//            }
//
//        }
//
//        response.setStatus(HttpServletResponse.SC_OK);
//
//    }
//
//}
