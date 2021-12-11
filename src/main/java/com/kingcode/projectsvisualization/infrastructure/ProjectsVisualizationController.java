package com.kingcode.projectsvisualization.infrastructure;


import com.kingcode.projectsvisualization.application.commits.Commit;
import com.kingcode.projectsvisualization.application.commits.CommitService;
import com.kingcode.projectsvisualization.application.github.MyGitHub;
import com.kingcode.projectsvisualization.application.projects.Project;
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

    //    @Value("${github.token}")
//    private String token;
    private final MyGitHub gitHub;
    private final CommitService commitService;
    private final ProjectService projectService;

//    public ProjectsVisualizationController(MyGitHub gitHub) {
//        this.gitHub = gitHub;
//    }

    @GetMapping("/api")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }

    @GetMapping("/api/projects")
    public ResponseEntity<List<Project>> getAllProjects() throws IOException {
        List<Project> projects = gitHub.getProjects();
       //    projectService.saveAllProjectToElastic(projects);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/api/commits")
    public ResponseEntity<List<Commit>> getAllCommits() throws IOException {
        List<Commit> allCommits = gitHub.getAllCommits();
        commitService.saveAllCommitsToElastic(allCommits);
        return ResponseEntity.ok(allCommits);
    }

    @GetMapping("/api/organizations")
    public ResponseEntity< List<GHOrganization>> getOrganizations() throws IOException {
        return ResponseEntity.ok(gitHub.getOrganizations());
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
