package com.kingcode.projectsvisualization.infrastructure;


import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.commits.CommitService;
import com.kingcode.projectsvisualization.application.github.MyGitHub;
import com.kingcode.projectsvisualization.application.projects.ProjectEntity;
import com.kingcode.projectsvisualization.application.projects.ProjectService;
import lombok.AllArgsConstructor;
import org.kohsuke.github.GHOrganization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController("/")
@AllArgsConstructor
public class ProjectsVisualizationController {

    private final MyGitHub gitHub;

    @GetMapping("/api")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }

    @PostMapping("/api/projects")
    public ResponseEntity<Iterable<ProjectEntity>> postAllProjects() throws IOException {
        return ResponseEntity.ok(gitHub.saveProjects());
    }

    @GetMapping("/api/projects")
    public ResponseEntity<Iterable<ProjectEntity>> getAllProjects() throws IOException {
        return ResponseEntity.ok(gitHub.getProjects());
    }

//    @GetMapping("/api/projects")
//    public ResponseEntity<List<ProjectEntity>> getAllProjects() throws IOException {
//        List<ProjectEntity> projects = gitHub.getProjects();
//       //    projectService.saveAllProjectToElastic(projects);
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("/api/commits")
//    public ResponseEntity<List<CommitEntity>> getAllCommits() throws IOException {
//        List<CommitEntity> allCommits = gitHub.getAllCommits();
//        commitService.saveAllCommitsToElastic(allCommits);
//        return ResponseEntity.ok(allCommits);
//    }
//
//    @GetMapping("/api/organizations")
//    public ResponseEntity< List<GHOrganization>> getOrganizations() throws IOException {
//        return ResponseEntity.ok(gitHub.getOrganizations());
//    }



    @PostMapping("/api/commits")
    public ResponseEntity<String> postAllCommits() {
        return ResponseEntity.ok("Commits saved");
    }
}
