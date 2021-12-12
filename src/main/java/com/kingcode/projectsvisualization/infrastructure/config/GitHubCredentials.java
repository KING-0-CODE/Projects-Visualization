package com.kingcode.projectsvisualization.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration("GitHubCredentials")
@ConfigurationProperties(prefix = "github")
public class GitHubCredentials {
    private String accessToken;
}
