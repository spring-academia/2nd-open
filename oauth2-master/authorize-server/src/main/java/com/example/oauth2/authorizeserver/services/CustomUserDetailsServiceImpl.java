package com.example.oauth2.authorizeserver.services;

import com.example.oauth2.authorizeserver.models.dtos.CustomUserDetails;
import com.example.oauth2.authorizeserver.models.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userService.getUser(UserEntity.builder().username(username).build());
        if(userEntity == null){
            throw new UsernameNotFoundException("The user not exist. Please check again.");
        }

        CustomUserDetails.CustomUserDetailsBuilder customUserDetailsBuilder = CustomUserDetails.builder();
        customUserDetailsBuilder
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(Arrays.stream(userEntity.getRoles().split(",")).map(x-> new SimpleGrantedAuthority(x)).collect(Collectors.toList()))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true);

        return customUserDetailsBuilder.build();
    }
}
