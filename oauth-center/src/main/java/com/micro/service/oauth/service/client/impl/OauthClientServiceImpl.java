package com.micro.service.oauth.service.client.impl;

import com.micro.service.oauth.model.client.OauthClientDetails;
import com.micro.service.oauth.model.dto.OauthClientDetailsDto;
import com.micro.service.oauth.repository.jdbc.OauthClinetRepositoryJdbc;
import com.micro.service.oauth.service.client.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 1:49 PM
 */

@Service
public class OauthClientServiceImpl implements OauthClientService {

    @Autowired
    private OauthClinetRepositoryJdbc oauthClinetRepositoryJdbc;


    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) {
        return oauthClinetRepositoryJdbc.findOauthClientDetails(clientId);
    }

    @Override
    public List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos() {
        List<OauthClientDetails> clientDetailses = oauthClinetRepositoryJdbc.findAllOauthClientDetails();
        return OauthClientDetailsDto.toDtos(clientDetailses);
    }

    @Override
    public void archiveOauthClientDetails(String clientId) {
        oauthClinetRepositoryJdbc.updateOauthClientDetailsArchive(clientId, true);
    }

    @Override
    public OauthClientDetailsDto loadOauthClientDetailsDto(String clientId) {
        final OauthClientDetails oauthClientDetails = oauthClinetRepositoryJdbc.findOauthClientDetails(clientId);
        return oauthClientDetails != null ? new OauthClientDetailsDto(oauthClientDetails) : null;
    }

    @Override
    public void registerClientDetails(OauthClientDetailsDto formDto) {
        OauthClientDetails clientDetails = formDto.createDomain();
        oauthClinetRepositoryJdbc.saveOauthClientDetails(clientDetails);
    }
}
