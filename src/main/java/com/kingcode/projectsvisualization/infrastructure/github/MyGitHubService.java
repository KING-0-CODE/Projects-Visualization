package com.kingcode.projectsvisualization.infrastructure.github;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class MyGitHubService implements MyGitHub {

    private final GitHub gitHub;

    @Override
    public List<GHCommit> getAllCommits() throws IOException {
        List<GHCommit> ghCommits = new ArrayList<>();
        PagedIterable<GHRepository> ghRepositories = gitHub.getMyself().listRepositories();
        for (GHRepository ghRepository : ghRepositories) {
            List<GHCommit> c = ghRepository.listCommits().toList();
            ghCommits.addAll(c);
        }
        return ghCommits;
    }

    @Override
    public List<GHRepository> getAllRepositories() throws IOException {
        return gitHub.getMyself().listRepositories().toList();
    }
}