package com.example.oauth2.authorizeserver.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableJpaRepositories(basePackages = {"com.example.oauth2.authorizeserver.repositories"})
@EntityScan(basePackages = {"com.example.oauth2.authorizeserver.models"}, basePackageClasses = {Jsr310Converters.class})
public class DefaultSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
          .formLogin(withDefaults());
        return http.build();
    }
}
