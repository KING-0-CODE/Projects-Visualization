package com.kingcode.projectsvisualization.infrastructure.github;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MyGitHubService implements MyGitHub {

    private final GitHub gitHub;

    @Override
    public List<GHCommit> getAllCommits() {
        List<GHCommit> ghCommits = new ArrayList<>();
        try {
            for (GHRepository repository : gitHub.getMyself().listRepositories()) {
                ghCommits.addAll(repository.listCommits().toList());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ghCommits;
    }

//    public void saveEveryRepoBranches() throws IOException {
//        List<CommitEntity> commitEntities = new ArrayList<>();
//        gitHub.getMyself().listRepositories().forEach(repository -> {
//            repository.getBranches().values().forEach(x->x.);
//        }
//
//    }
}