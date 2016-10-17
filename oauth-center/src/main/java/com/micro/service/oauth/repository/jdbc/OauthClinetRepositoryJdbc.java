package com.micro.service.oauth.repository.jdbc;

import com.micro.service.oauth.model.client.OauthClientDetails;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 1:38 PM
 */

public interface OauthClinetRepositoryJdbc {

    OauthClientDetails findOauthClientDetails(String clientId);

    List<OauthClientDetails> findAllOauthClientDetails();

    void updateOauthClientDetailsArchive(String clientId, boolean archive);

    void saveOauthClientDetails(OauthClientDetails clientDetails);
}
