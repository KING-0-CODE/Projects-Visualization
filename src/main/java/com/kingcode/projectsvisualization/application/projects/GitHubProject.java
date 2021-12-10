package com.kingcode.projectsvisualization.application.projects;

import lombok.Data;

@Data
public class GitHubProject {
    private Integer projectId;
    private String projectName;
    private String description;
}
