package com.kingcode.projectsvisualization.application.commits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommitService {
    private final CommitRepo commitRepo;

    public Iterable<Commit> saveAllCommitsToElastic(List<Commit> commits) {
        return commitRepo.saveAll(commits);
    }

    public Iterable<Commit> getAllCommitsFromElastic() {
        return commitRepo.findAll();
    }
}
