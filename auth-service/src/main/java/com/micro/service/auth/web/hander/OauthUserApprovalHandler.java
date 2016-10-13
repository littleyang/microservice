package com.micro.service.auth.web.hander;

import com.micro.service.auth.model.auth.OauthClientDetails;
import com.micro.service.auth.service.OauthService;


import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 6:12 PM
 */

public class OauthUserApprovalHandler extends TokenStoreUserApprovalHandler {

    private OauthService oauthService;

    public OauthUserApprovalHandler() {
        // Do nothing
    }


    /**
     * 这儿扩展了默认的逻辑, 若 OauthClientDetails 中的 trusted 字段为true, 将会自动跳过 授权流程
     *
     * @param authorizationRequest AuthorizationRequest
     * @param userAuthentication   Authentication
     * @return True is approved
     */
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        if (super.isApproved(authorizationRequest, userAuthentication)) {
            return true;
        }
        if (!userAuthentication.isAuthenticated()) {
            return false;
        }

        OauthClientDetails clientDetails = oauthService.loadOauthClientDetails(authorizationRequest.getClientId());
        if (clientDetails != null) if (clientDetails.trusted()) return true;
        return false;

    }

    public void setOauthService(OauthService oauthService) {
        this.oauthService = oauthService;
    }
}
