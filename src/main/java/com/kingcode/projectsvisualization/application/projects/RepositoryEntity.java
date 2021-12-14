//package com.kingcode.projectsvisualization.application.projects;
//
//import lombok.*;
//import lombok.extern.slf4j.Slf4j;
//import org.kohsuke.github.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
////@Slf4j
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Service
//@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.projects')}")
//public class RepositoryEntity {
//    @Id
//    private long projectId;
//    private String projectName;
//    private String description;
//    private Integer forksCount;
//    private Branch branch;
//    private Issue issue;
//    private PullRequest pullRequest;
//
//    public List<RepositoryEntity> map(List<GHRepository> ghRepositories, GHBranch ghBranch, GHIssue ghIssue, GHPullRequest ghPullRequest) throws Exception {
//        List<RepositoryEntity> list = new ArrayList<>();
//        for (GHRepository ghRepository : ghRepositories) {
//            RepositoryEntity repositoryEntity = map(ghRepository, ghBranch, ghIssue, ghPullRequest);
//            list.add(repositoryEntity);
//        }
//        return list;
//    }
//
//    private RepositoryEntity map(GHRepository ghRepository, GHBranch ghBranch, GHIssue ghIssue, GHPullRequest ghPullRequest) throws Exception {
//        return RepositoryEntity.builder()
//            .projectId((ghRepository.getId()))
//            .projectName(ghRepository.getFullName())
//            .description(ghRepository.getDescription())
//            .forksCount(ghRepository.getForksCount())
//            .branch(mapBranch(ghBranch))
//            .issue(mapIssue(ghIssue))
//            .pullRequest(mapPullRequest(ghPullRequest))
//            .build();
//    }
//
//    private Branch mapBranch(GHBranch ghBranch) throws Exception {
//        Branch branch = new Branch();
//        branch.setBranchName(ghBranch.getName());
//        return branch;
//    }
//
//    private Issue mapIssue(GHIssue ghIssue) throws Exception {
//        Issue issue = new Issue();
//        issue.setNumber(ghIssue.getNumber());
//        issue.setBody(ghIssue.getBody());
//        issue.setTitle(ghIssue.getTitle());
//        issue.setClosed_by(ghIssue.getClosedBy());
//        return issue;
//    }
//
//    private PullRequest mapPullRequest(GHPullRequest ghPullRequest) throws IOException {
//        PullRequest pullRequest = new PullRequest();
//        pullRequest.setCommits(ghPullRequest.getCommits());
//        pullRequest.setMerged(ghPullRequest.isMerged());
//        return pullRequest;
//    }
//}
//
//@Getter
//@Setter
//class Branch {
//    private String branchName;
//}
//
//@Getter
//@Setter
//class Issue {
//    private int number;
//    private String body;
//    private String title;
//    private GHUser closed_by;
//}
//
//@Getter
//@Setter
//class PullRequest {
//    private int commits;
//    private boolean merged;
//}