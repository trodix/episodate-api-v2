package com.trodix.episodate.episodateapi.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@Slf4j
public class WebSecurityConfig {

        @Bean
        public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
                return new NullAuthenticatedSessionStrategy();
        }

        @Bean
        public SecurityFilterChain filterChain(
                HttpSecurity http,
                KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter,
                CorsConfigurationSource corsConfigurationSource
        ) throws Exception {

                http.cors(c -> c.configurationSource(corsConfigurationSource));

                // OAUTH authentication
                http
                        .securityMatcher("/api/v1/public/**")
                        .authorizeHttpRequests(
                                config -> config.requestMatchers("/api/v1/public/**").permitAll()
                        )
                        .securityMatcher("/api/v1/**")
                        .oauth2ResourceServer(
                                config -> config.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(keycloakJwtAuthenticationConverter))
                        )
                        .authorizeHttpRequests(c -> c.anyRequest().authenticated())
                ;

                return http.build();
        }

        @Bean
        @Primary
        public CorsConfigurationSource corsConfigurationSource(CorsProperties corsProperties) {
                log.info("Registering CORS configuration with allowed origins {}", corsProperties.getAllowedOrigins());

                final CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList(corsProperties.getAllowedOrigins()));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
                configuration.setAllowCredentials(true);
                configuration.setAllowedHeaders(List.of("*"));
                configuration.setExposedHeaders(List.of("X-Get-Header"));
                configuration.setMaxAge(3600L);
                final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);

                return source;
        }
}
