package com.kingcode.projectsvisualization.application.commits;

import com.kingcode.projectsvisualization.infrastructure.github.MyGitHubService;
import lombok.RequiredArgsConstructor;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CommitService {
    private final CommitRepo commitRepo;

    private final MyGitHubService myGitHubService;

    public Iterable<CommitEntity> saveAllCommitsToElastic() throws IOException {
        List<CommitEntity> commitEntities = new ArrayList<>();
        for (GHRepository ghRepository : myGitHubService.getAllRepositories()) {
            for (GHCommit ghCommit : myGitHubService.getAllCommits()) {
                CommitEntity commitEntity = CommitEntity.toCommit(ghCommit, ghRepository);
                commitEntities.add(commitEntity);

            }
        }
        return commitRepo.saveAll(commitEntities);
//            commitEntities = myGitHubService.getAllCommits()
//                .stream()
//                .map((GHCommit ghCommit) -> CommitEntity.toCommit(ghCommit, ghRepository))
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//        return StreamSupport.stream(commitRepo.saveAll(commitEntities).spliterator(), false)
//            .collect(Collectors.toList());
    }

    public Iterable<CommitEntity> getAllCommitsFromElastic() {
        return commitRepo.findAll();
    }
}
