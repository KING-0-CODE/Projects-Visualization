package com.kingcode.projectsvisualization.application.github;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHBranch.*;
import org.kohsuke.github.GHProject.*;

import java.util.List;

public class GitHubImpl implements GitHub {

    private final GitHub gitHubApi;

    public GitHubImpl(GitHub gitHub, GitHub gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    @Override
    public List<ProjectState> getProjects() {
        return gitHubApi.getProjects();
    }

    @Override
    public List<Commit> getCommitsByProjectAndBranch(int projectId) {
        return gitHubApi.getCommitsByProjectAndBranch(projectId);
    }

    @Override
    public List<GHBranch> getBranches(int projectId) {
        return gitHubApi.getBranches(projectId);
    }
}
