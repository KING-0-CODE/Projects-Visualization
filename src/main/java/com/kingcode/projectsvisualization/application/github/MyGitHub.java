package com.kingcode.projectsvisualization.application.github;

import com.kingcode.projectsvisualization.application.commits.Commit;
import com.kingcode.projectsvisualization.application.projects.Project;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHOrganization;

import java.io.IOException;
import java.util.List;

public interface MyGitHub {

    List<Project> getProjects() throws IOException;

    List<Commit> getAllCommits() throws IOException;

    List<GHBranch> getBranches(int projectId);

    List<GHOrganization> getOrganizations() throws IOException;
}
