package com.kingcode.projectsvisualization.application.commits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommitService {
    private final CommitRepo commitRepo;

    public Iterable<CommitEntity> saveAllCommitsToElastic(List<CommitEntity> commits) {
        return commitRepo.saveAll(commits);
    }

    public Iterable<CommitEntity> getAllCommitsFromElastic() {
        return commitRepo.findAll();
    }
}
