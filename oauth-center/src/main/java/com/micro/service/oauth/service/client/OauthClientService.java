package com.micro.service.oauth.service.client;

import com.micro.service.oauth.model.client.OauthClientDetails;
import com.micro.service.oauth.model.dto.OauthClientDetailsDto;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 1:48 PM
 */

public interface OauthClientService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}
