package com.kingcode.projectsvisualization.application.github;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHBranch.Commit;
import org.kohsuke.github.GHCompare;
import org.kohsuke.github.GHProject.ProjectState;

import java.util.List;

public interface GitHub {
    List<ProjectState> getProjects();

    List<Commit> getCommitsByProjectAndBranch(int projectId);

    List<GHBranch> getBranches(int projectId);
}
