package com.kingcode.projectsvisualization.application.github;

//import com.kingcode.projectsvisualization.application.projects.RepositoryEntity;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;

import java.io.IOException;
import java.util.List;

public interface MyGitHub {

    List<CommitEntity> saveAllCommits() throws IOException;

    Iterable<CommitEntity> getAllCommits() throws IOException;
}
