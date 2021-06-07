package com.example.oauth2.authorizeserver.services;

import com.example.oauth2.authorizeserver.models.entities.UserEntity;
import com.example.oauth2.authorizeserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUser(UserEntity userEntity){
        return userRepository.findByUsername(userEntity.getUsername());
    }

}
