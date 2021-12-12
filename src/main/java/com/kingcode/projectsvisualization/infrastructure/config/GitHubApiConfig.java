package com.kingcode.projectsvisualization.infrastructure.config;

import lombok.AllArgsConstructor;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@AllArgsConstructor
public class GitHubApiConfig {
    private final GitHubCredentials gitHubCredentials;

    @Bean
    public GitHub gitHub() throws IOException {
        return new GitHubBuilder().withOAuthToken(gitHubCredentials.getAccessToken()).build();
    }
}
