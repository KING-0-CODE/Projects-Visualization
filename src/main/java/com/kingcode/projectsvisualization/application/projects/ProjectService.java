package com.kingcode.projectsvisualization.application.projects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepo projectRepo;

    public void saveAllProjectToElastic(List<ProjectEntity> projects) {
        projectRepo.saveAll(projects);
    }

    public Iterable<ProjectEntity> getAllProjectFromElastic() {
        return projectRepo.findAll();
    }
}
