package com.micro.service.auth.service;

import com.micro.service.auth.model.auth.OauthClientDetails;
import com.micro.service.auth.model.dto.OauthClientDetailsDto;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 5:02 PM
 */

public interface OauthService {

    public OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}
