package com.example.product_store_server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final CustomOAuth2LoginSuccessHandler successHandler;

    public SecurityConfig(CustomOAuth2LoginSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers( "/login").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .defaultSuccessUrl("http://localhost:8081/users/1", true) // Ensure successful login redirects to frontend
                                .successHandler(this.successHandler)
                );
//                .cors(cors -> cors
//                        .configurationSource(request -> {
//                                    var corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
//                                    corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
//                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//                            corsConfiguration.setAllowedHeaders(List.of("*"));
//                            corsConfiguration.setAllowCredentials(true);
//                            return corsConfiguration;
//                        })
//                );

        return http.build();
    }

}
