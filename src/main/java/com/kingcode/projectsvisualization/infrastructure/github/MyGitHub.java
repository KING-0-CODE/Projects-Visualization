package com.kingcode.projectsvisualization.infrastructure.github;

//import com.kingcode.projectsvisualization.application.projects.RepositoryEntity;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import org.kohsuke.github.GHCommit;

import java.io.IOException;
import java.util.List;

public interface MyGitHub {

    List<GHCommit> getAllCommits() throws IOException;

}
