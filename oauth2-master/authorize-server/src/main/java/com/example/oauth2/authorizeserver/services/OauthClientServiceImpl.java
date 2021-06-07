package com.example.oauth2.authorizeserver.services;

import com.example.oauth2.authorizeserver.models.entities.OauthClientEntity;
import com.example.oauth2.authorizeserver.repositories.OauthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OauthClientServiceImpl implements OauthClientService {

    private final OauthClientRepository oauthClientRepository;

    @Autowired
    public OauthClientServiceImpl(OauthClientRepository oauthClientRepository) {
        this.oauthClientRepository = oauthClientRepository;
    }

    @Override
    public List<OauthClientEntity> getOauthClientList() { return oauthClientRepository.findAll(); }

    @Override
    public OauthClientEntity getOauthClientById(String id) {
        return oauthClientRepository.getOne(id);
    }

    @Override
    public OauthClientEntity getOauthClientByClientId(String clientId){
        return oauthClientRepository.findByClientId(clientId);
    }

}
