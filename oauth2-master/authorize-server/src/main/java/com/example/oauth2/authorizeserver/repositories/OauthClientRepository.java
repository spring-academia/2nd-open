package com.example.oauth2.authorizeserver.repositories;

import com.example.oauth2.authorizeserver.models.entities.OauthClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientRepository extends JpaRepository<OauthClientEntity, String> {
    OauthClientEntity findByClientId(String clientId);
}
