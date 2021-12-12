package com.kingcode.projectsvisualization.application.github;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.projects.ProjectEntity;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHOrganization;

import java.io.IOException;
import java.util.List;

public interface MyGitHub {

    List<ProjectEntity> getProjects() throws IOException;

    List<CommitEntity> getAllCommits() throws IOException;

    List<GHBranch> getBranches(int projectId);

    List<GHOrganization> getOrganizations() throws IOException;
}
