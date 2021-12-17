package com.kingcode.projectsvisualization.infrastructure;


import com.kingcode.projectsvisualization.application.branches.BranchEntity;
import com.kingcode.projectsvisualization.application.branches.BranchService;
import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.commits.CommitService;
import com.kingcode.projectsvisualization.infrastructure.github.MyGitHubService;
import lombok.AllArgsConstructor;
import org.kohsuke.github.GHCommit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController("/")
@AllArgsConstructor
public class ProjectsVisualizationController {

    private final CommitService commitService;
    private final BranchService branchService;

    @GetMapping("/api")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }

    @PostMapping("/commits")
    public ResponseEntity<Iterable<CommitEntity>> saveAllCommits() throws IOException {
        return ResponseEntity.ok(commitService.saveAllCommitsToElastic());
    }

    @GetMapping("/commits")
    public ResponseEntity<Iterable<CommitEntity>> getAllCommits() {
        return ResponseEntity.ok(commitService.getAllCommitsFromElastic());
    }

    @PostMapping("/branches")
    public ResponseEntity<List<BranchEntity>> saveAllBranches() throws IOException {
        return ResponseEntity.ok(branchService.saveAllBranchesToElastic());
    }

    @GetMapping("/branches")
    public ResponseEntity<Iterable<BranchEntity>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranchesFromElastic());
    }
}