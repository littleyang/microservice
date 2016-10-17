package com.micro.service.oauth.repository.jdbc.impl;

import com.micro.service.oauth.model.client.OauthClientDetails;
import com.micro.service.oauth.repository.base.RepositoryJdbcBase;
import com.micro.service.oauth.repository.jdbc.OauthClinetRepositoryJdbc;
import com.micro.service.oauth.repository.jdbc.mapper.OauthClientDetailsRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-17 1:39 PM
 */
@Repository
public class OauthRepositoryJdbcImpl extends RepositoryJdbcBase implements OauthClinetRepositoryJdbc {

    private static OauthClientDetailsRowMapper oauthClientDetailsRowMapper = new OauthClientDetailsRowMapper();

    @Override
    public OauthClientDetails findOauthClientDetails(String clientId) {

        final StringBuilder sqlBuilder = new StringBuilder("select * from oauth_client_details where  client_id = ?");

        final List<OauthClientDetails> list = this.jdbcTemplate.query(sqlBuilder.toString(),
                new Object[]{clientId}, oauthClientDetailsRowMapper);

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<OauthClientDetails> findAllOauthClientDetails() {
        final StringBuilder sqlBuilder = new StringBuilder("select * from oauth_client_details order by create_time desc");
        return this.jdbcTemplate.query(sqlBuilder.toString(), oauthClientDetailsRowMapper);
    }

    @Override
    public void updateOauthClientDetailsArchive(String clientId, boolean archive) {
        final StringBuilder sqlBuilder = new StringBuilder("update oauth_client_details set archived = ? where client_id = ?");
        this.jdbcTemplate.update(sqlBuilder.toString(), archive, clientId);
    }

    @Override
    public void saveOauthClientDetails(OauthClientDetails clientDetails) {

        final StringBuilder sqlBuilder = new StringBuilder("insert into oauth_client_details(client_id,resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri," +
                " authorities,access_token_validity,refresh_token_validity,additional_information,trusted,autoapprove) values (?,?,?,?,?,?,?,?,?,?,?,?)");
        this.jdbcTemplate.update(sqlBuilder.toString(), ps -> {
            ps.setString(1, clientDetails.clientId());
            ps.setString(2, clientDetails.resourceIds());

            ps.setString(3, clientDetails.clientSecret());
            ps.setString(4, clientDetails.scope());

            ps.setString(5, clientDetails.authorizedGrantTypes());
            ps.setString(6, clientDetails.webServerRedirectUri());

            ps.setString(7, clientDetails.authorities());
            ps.setObject(8, clientDetails.accessTokenValidity());

            ps.setObject(9, clientDetails.refreshTokenValidity());
            ps.setString(10, clientDetails.additionalInformation());

            ps.setBoolean(11, clientDetails.trusted());
            ps.setString(12, clientDetails.autoApprove());

        });
    }
}
