package com.kingcode.projectsvisualization.application.projects;

import com.kingcode.projectsvisualization.application.commits.CommitEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.projects')}")
public class ProjectEntity {
    @Id
    private long projectId;
    private String projectName;
    private String description;
    private Integer forksCount;
    private List<Issue> issues;
    private List<CommitEntity> commits;
    private Set<String> collaboratorNames;
    private List<PullRequest> pullRequests;
    private Map<String, Branch> branchesMap;

    public static ProjectEntity toProject(GHRepository ghRepository) throws IOException {
        return ProjectEntity.builder()
            .projectId(ghRepository.getId())
            .projectName(ghRepository.getName())
            .description(ghRepository.getDescription())
            .forksCount(ghRepository.getForksCount())
            .issues(ghRepository.getIssues(GHIssueState.ALL).stream().map(ghIssue -> {
                    try {
                        return Issue.toIssue(ghIssue);
                    } catch (IOException e) {
                        log.error("Could not get any Issue!", e);
                        throw new UncheckedIOException(e);
                    }
                })
                .collect(Collectors.toList()))
            .commits(ghRepository.listCommits().toList().stream().map(ghCommit -> {
                    try {
                        return CommitEntity.toCommit(ghCommit);
                    } catch (IOException e) {
                        log.error("Could not get any project!", e);
                        throw new UncheckedIOException(e);
                    }
                })
                .collect(Collectors.toList()))
            .collaboratorNames(ghRepository.getCollaboratorNames())
            .pullRequests(ghRepository.getPullRequests(GHIssueState.ALL).stream().map(ghPullRequest -> {
                    try {
                        return PullRequest.toPullRequest(ghPullRequest);
                    } catch (IOException e) {
                        log.error("Could not get any of pull requests!", e);
                        e.printStackTrace();
                        throw new UncheckedIOException(e);
                    }
                })
                .collect(Collectors.toList()))
            .branchesMap(ghRepository.getBranches().entrySet().stream().map(e ->
                new AbstractMap.SimpleEntry<>(e.getKey(), Branch.toBranch(e.getValue()))
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new)))

            .build();
    }
}

@Builder
class Branch {

    private String branchName;
//    private CommitEntity commit;

    public static Branch toBranch(GHBranch ghBranch) {
        return Branch.builder()
            .branchName(ghBranch.getName())
            .build();
    }
}

@Builder
class Issue {
    private int number;
    private String body;
    private int comments;
    private String title;
    private String closed_by;
    private Collection<GHLabel> labels;

    public static Issue toIssue(GHIssue ghIssue) throws IOException {
        return Issue.builder()
            .number(ghIssue.getNumber())
            .body(ghIssue.getBody())
            .comments(ghIssue.getCommentsCount())
            .title(ghIssue.getTitle())
            .closed_by(ghIssue.getClosedBy().getName())
            .labels(ghIssue.getLabels())
            .build();
    }
}

@Builder
class PullRequest {

    private int review_comments;
    private int additions;
    private int commits;
    private boolean merged;

    public static PullRequest toPullRequest(GHPullRequest ghPullRequest) throws IOException {
        return PullRequest.builder()
            .review_comments(ghPullRequest.getReviewComments())
            .additions(ghPullRequest.getAdditions())
            .commits(ghPullRequest.getCommits())
            .merged(ghPullRequest.isMerged())
            .build();
    }
}