package com.trodix.episodate.v2.episodateapi.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cors")
@Data
public class CorsProperties {
    private String[] allowedOrigins;
}