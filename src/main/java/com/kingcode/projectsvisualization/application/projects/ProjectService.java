package com.kingcode.projectsvisualization.application.projects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepo projectRepo;

    public void saveAllProjectToElastic(List<Project> projects) {
        projectRepo.saveAll(projects);
    }

    public Iterable<Project> getAllProjectFromElastic() {
        return projectRepo.findAll();
    }
}
