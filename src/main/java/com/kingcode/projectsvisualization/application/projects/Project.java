package com.kingcode.projectsvisualization.application.projects;

import com.kingcode.projectsvisualization.application.commits.Commit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.projects')}")
public class Project {

    @Id
    private long projectId;
    private String projectName;
    private String description;
    private Integer forksCount;
    private List<Issue> issues;
    private List<Commit> commits;
    private Set<String> collaboratorNames;
    private List<PullRequest> pullRequests;
    private Map<String, Branch> branchesMap;

    public static Project toProject(GHRepository p) throws IOException {
        return Project.builder()
                .projectId(p.getId())
                .projectName(p.getName())
                .description(p.getDescription())
                .forksCount(p.getForksCount())
                .issues(p.getIssues(GHIssueState.ALL).stream().map(Issue::toIssue).collect(Collectors.toList()))
                .commits(p.listCommits().toList().stream().map(ghCommit -> {
                    try {
                        return Commit.toCommit(ghCommit);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }).collect(Collectors.toList()))
                .collaboratorNames(p.getCollaboratorNames())
                .pullRequests(p.getPullRequests(GHIssueState.ALL).stream().map(PullRequest::toPullRequest).collect(Collectors.toList()))
                .branchesMap(p.getBranches().entrySet().stream().map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), Branch.toBranch(e.getValue()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new)))
                .build();


    }
}
