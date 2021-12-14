package com.kingcode.projectsvisualization.infrastructure;


import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.github.MyGitHub;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("/")
@AllArgsConstructor
public class ProjectsVisualizationController {

    private final MyGitHub myGitHub;

    @GetMapping("/api")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }

    @PostMapping("/commits")
    public ResponseEntity<String> saveAllCommits() throws IOException {
        return ResponseEntity.ok("Commits saved");
    }

    @GetMapping("/commits")
    public ResponseEntity<Iterable<CommitEntity>> getAllCommits() throws IOException {
        return ResponseEntity.ok(myGitHub.getAllCommits());
    }
}
