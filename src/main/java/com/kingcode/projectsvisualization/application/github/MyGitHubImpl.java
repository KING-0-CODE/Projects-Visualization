package com.kingcode.projectsvisualization.application.github;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import com.kingcode.projectsvisualization.application.projects.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class MyGitHubImpl implements MyGitHub {

    private final GitHub gitHubApi;

    @Override
    public List<ProjectEntity> getProjects() throws IOException {
        return gitHubApi.getMyself().getAllRepositories().values().stream().map(ghRepository -> {
            try {
                return ProjectEntity.toProject(ghRepository);
            } catch (IOException e) {
                log.error("Could not get any project!", e);
                throw new UncheckedIOException(e);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public List<CommitEntity> getAllCommits() throws IOException {
        Collection<GHRepository> values = gitHubApi.getMyself().getAllRepositories().values();

        List<GHCommit> allCommits = new LinkedList<>();
        List<CommitEntity> allAppCommits = new LinkedList<>();

        for (GHRepository r : values) {
            List<GHCommit> commits = r.listCommits().toList();
            allCommits.addAll(commits);
        }

        for (GHCommit c : allCommits) {
            String[] split = c.getUrl().toString().split("/");
            String id = split[split.length - 1];
            CommitEntity commit = CommitEntity.builder()
                .id(id)
                .authorEmail(c.getCommitShortInfo().getAuthor().getEmail())
                .authorName(c.getCommitShortInfo().getAuthor().getName())
                .message(c.getCommitShortInfo().getMessage())
                .createdAt(c.getCommitDate())
                .build();
            allAppCommits.add(commit);
        }
        return allAppCommits;
    }

    @Override
    public List<GHBranch> getBranches(int projectId) {
        return null;
    }

    @Override
    public List<GHOrganization> getOrganizations() throws IOException {
        for (GHOrganization ghOrganization : gitHubApi.getMyOrganizations().values()) {
            System.out.println(ghOrganization.getName());
        }
        GHMyself myself = gitHubApi.getMyself();
        return new ArrayList<>(myself.getOrganizations());
    }
}
