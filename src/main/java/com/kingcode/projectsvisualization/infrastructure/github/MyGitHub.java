package com.kingcode.projectsvisualization.infrastructure.github;

//import com.kingcode.projectsvisualization.application.projects.RepositoryEntity;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.util.List;

public interface MyGitHub {

    List<GHCommit> getAllCommits() throws IOException;

    List<GHRepository> getAllRepositories() throws IOException;
}
