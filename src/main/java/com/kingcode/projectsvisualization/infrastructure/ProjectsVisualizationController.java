package com.kingcode.projectsvisualization.infrastructure;


import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.commits.CommitService;
import com.kingcode.projectsvisualization.infrastructure.github.MyGitHub;
import lombok.AllArgsConstructor;
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

    @GetMapping("/api")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }

    @PostMapping("/commits")
    public ResponseEntity<List<CommitEntity>> saveAllCommits() throws IOException {
        return ResponseEntity.ok(commitService.saveAllCommitsToElastic());
    }

    @GetMapping("/commits")
    public ResponseEntity<Iterable<CommitEntity>> getAllCommits() throws IOException {
        return ResponseEntity.ok(commitService.getAllCommitsFromElastic());
    }
}
