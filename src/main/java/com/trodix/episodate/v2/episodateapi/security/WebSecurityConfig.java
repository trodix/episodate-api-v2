package com.trodix.episodate.v2.episodateapi.security;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2ClientConfigurer;
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
public class WebSecurityConfig {

        private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

//        @Value("${app.auth.allowed-origins}")
//        private String[] allowedOrigins;

        @Bean
        public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
                return new NullAuthenticatedSessionStrategy();
        }

        @Bean
        public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

                http.cors(CorsConfigurer::disable);

                // OAUTH authentication
                http
                        .securityMatcher("/api/v2/public/**")
                        .authorizeHttpRequests(
                                config -> config.requestMatchers("/api/v2/public/**").permitAll()
                        )
                        .securityMatcher("/api/v2/**")
                        .oauth2ResourceServer(
                                config -> config.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(keycloakJwtAuthenticationConverter))
                        )
                        .authorizeHttpRequests(c -> c.anyRequest().authenticated())
                ;

                return http.build();
        }

//        @Bean
//        public CorsConfigurationSource corsConfigurationSource() {
//                final CorsConfiguration configuration = new CorsConfiguration();
//                configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
//                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
//                configuration.setAllowCredentials(true);
//                configuration.setAllowedHeaders(List.of("*"));
//                configuration.setExposedHeaders(List.of("X-Get-Header"));
//                configuration.setMaxAge(3600L);
//                final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//                source.registerCorsConfiguration("/**", configuration);
//
//                return source;
//        }
}
