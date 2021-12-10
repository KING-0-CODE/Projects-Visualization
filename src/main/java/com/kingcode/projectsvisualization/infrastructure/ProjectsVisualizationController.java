package com.kingcode.projectsvisualization.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectsVisualizationController {

    @GetMapping("/")
    public ResponseEntity<String> welcomeHome() {
        return ResponseEntity.ok("Welcome Home");
    }
}
