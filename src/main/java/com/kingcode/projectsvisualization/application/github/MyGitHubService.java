package com.kingcode.projectsvisualization.application.github;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.commits.CommitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class MyGitHubService implements MyGitHub {

    private final GitHub gitHub;
    private final CommitService commitService;

    @Override
    public void saveAllCommits() throws IOException {
        List<CommitEntity> commitEntities = new ArrayList<>();
        gitHub.getMyself().listRepositories().forEach(repository -> {
            try {
                log.info("Fetching commits Data for CommitEntity...");
                repository.listCommits().toList().forEach(commit -> {
                    try {
                        CommitEntity commitEntity = CommitEntity.toCommit(commit);
                        commitEntities.add(commitEntity);
                    } catch (IOException ex) {
                        log.error("Fetching commits unsuccessful!" + ex );
                        ex.printStackTrace();
                    }
                });
                commitService.saveAllCommitsToElastic(commitEntities);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @Override
    public Iterable<CommitEntity> getAllCommits() throws IOException {
        return commitService.getAllCommitsFromElastic();
    }
}
