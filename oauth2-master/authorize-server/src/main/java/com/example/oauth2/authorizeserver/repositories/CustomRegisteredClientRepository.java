package com.example.oauth2.authorizeserver.repositories;

import com.example.oauth2.authorizeserver.models.entities.OauthClientEntity;
import com.example.oauth2.authorizeserver.services.OauthClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
public class CustomRegisteredClientRepository implements RegisteredClientRepository {
    private final OauthClientService oauthClientService;

    public CustomRegisteredClientRepository(OauthClientService oAuthClientService) {
        this.oauthClientService = oAuthClientService;
    }

    @Override
    public RegisteredClient findById(String id) {
        Assert.hasText(id, "id cannot be empty");
        return registeredClientBuilder(oauthClientService.getOauthClientById(id));
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Assert.hasText(clientId, "clientId cannot be empty");
        return registeredClientBuilder(oauthClientService.getOauthClientByClientId(clientId));
    }

    private RegisteredClient registeredClientBuilder(OauthClientEntity oauthClientEntity){
        RegisteredClient.Builder registeredClientBuilder = RegisteredClient
                .withId(oauthClientEntity.getId())
                .clientId(oauthClientEntity.getClientId())
                .clientSecret(oauthClientEntity.getClientSecret())
                .clientAuthenticationMethod(new ClientAuthenticationMethod("basic"));

        Arrays.stream(oauthClientEntity.getAuthorizedGrantTypes().split(",")).forEach(
                grantType -> registeredClientBuilder.authorizationGrantType(new AuthorizationGrantType(grantType.trim()))
        );

        Arrays.stream(oauthClientEntity.getRedirectUris().split(",")).forEach(
                redirectUri -> registeredClientBuilder.redirectUri(redirectUri.trim())
        );

        Arrays.stream(oauthClientEntity.getScopes().split(",")).forEach(
                scope -> registeredClientBuilder.scope(scope.trim())
        );

        return registeredClientBuilder.build();
    }
}
