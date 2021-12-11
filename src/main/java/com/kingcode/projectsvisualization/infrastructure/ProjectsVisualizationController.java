package com.kingcode.projectsvisualization.infrastructure;

import com.kingcode.projectsvisualization.application.commits.Commit;
import com.kingcode.projectsvisualization.application.projects.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class ProjectsVisualizationController {

    @GetMapping("/api")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }

    @GetMapping("/api/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/api/commits")
    public ResponseEntity<List<Commit>> getAllCommits() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("/api/projects")
    public ResponseEntity<String> postAllProjects() {
        return ResponseEntity.ok("Project saved");
    }

    @PostMapping("/api/commits")
    public ResponseEntity<String> postAllCommits() {
        return ResponseEntity.ok("Commits saved");
    }
}
