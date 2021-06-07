package com.example.oauth2.authorizeserver.models.entities;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Getter
@Table(name = "oauth_client", schema = "security")
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthClientEntity implements Serializable {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(name = "client_id", length = 256)
    private String clientId;

    @Column(name = "client_secret", length = 256)
    private String clientSecret;

    @Column(name = "authentication_methods", length = 256)
    private String authenticationMethods;

    @Column(name = "authorized_grant_types", length = 256)
    private String authorizedGrantTypes;

    @Column(name = "redirect_uris", length = 256)
    private String redirectUris;

    @Column(name = "scopes", length = 256)
    private String scopes;

    @Builder
    public OauthClientEntity(String id, String clientId, String clientSecret, String authenticationMethods, String authorizedGrantTypes, String redirectUris, String scopes) {
        this.id = id;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authenticationMethods = authenticationMethods;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.redirectUris = redirectUris;
        this.scopes = scopes;
    }
}
