package com.kingcode.projectsvisualization.application.github;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.commits.CommitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class MyGitHubService implements MyGitHub {

    private final GitHub gitHub;
    private final CommitService commitService;

    @Override
    public List<CommitEntity> saveAllCommits() throws IOException {
        List<CommitEntity> commitEntities = new ArrayList<>();
        gitHub.getMyself().listRepositories().forEach(repository -> {
            try {
                repository.listCommits().toList().forEach(commit -> {
                    try {
                        log.info("Fetching commits Data for CommitEntity...");
                        CommitEntity commitEntity = CommitEntity.toCommit(commit);
                        log.info("Fetching commits Data Done.");
                        commitEntities.add(commitEntity);
                    } catch (IOException ex) {
                        log.error("Fetching commits unsuccessful!" + ex);
                        ex.printStackTrace();
                    }
                });
                commitEntities.forEach(e -> System.out.println(e + "\n"));
                commitService.saveAllCommitsToElastic(commitEntities);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        return commitEntities;
    }

    @Override
    public Iterable<CommitEntity> getAllCommits() throws IOException {
        return commitService.getAllCommitsFromElastic();
    }
}
