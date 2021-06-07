package com.example.oauth2.authorizeserver.repositories;

import com.example.oauth2.authorizeserver.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
