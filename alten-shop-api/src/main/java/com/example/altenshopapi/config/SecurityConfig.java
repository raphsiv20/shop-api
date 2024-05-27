package com.example.altenshopapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    private static final String[] AUTH_WHITELIST = {
            "/products/**",
            "/static/images/**",
    };


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .csrf().disable()
            .exceptionHandling()
            .and()
            .authorizeHttpRequests(authorize -> authorize
                    .anyRequest().permitAll()
                
            )
            .cors()
        ;
        return http.build();
    }

}