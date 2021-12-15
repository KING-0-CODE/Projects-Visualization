package com.kingcode.projectsvisualization.application.commits;

import com.kingcode.projectsvisualization.infrastructure.github.MyGitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CommitService {
    private final CommitRepo commitRepo;

    private final MyGitHubService myGitHubService;

    public List<CommitEntity> saveAllCommitsToElastic() throws IOException {
        List<CommitEntity> commitEntities = myGitHubService.getAllCommits().stream()
            .map(CommitEntity::toCommit)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        return StreamSupport.stream(commitRepo.saveAll(commitEntities).spliterator(), false)
            .collect(Collectors.toList());
    }

    public Iterable<CommitEntity> getAllCommitsFromElastic() {
        return commitRepo.findAll();
    }
}
