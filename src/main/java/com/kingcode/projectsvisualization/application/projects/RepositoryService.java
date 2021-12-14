//package com.kingcode.projectsvisualization.application.projects;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.kohsuke.github.GHBranch;
//import org.kohsuke.github.GHIssue;
//import org.kohsuke.github.GHPullRequest;
//import org.kohsuke.github.GHRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class RepositoryService {
//
//    private final RepositoryEntity projectEntity;
//    private final RepositoryRepo repositoryRepo;
//
//    public List<RepositoryEntity> saveAllProjectToElastic(List<GHRepository> ghRepositories, GHBranch ghBranch, GHIssue ghIssue, GHPullRequest ghPullRequest) throws Exception {
//        return (List<RepositoryEntity>) repositoryRepo.saveAll(projectEntity.map(ghRepositories, ghBranch, ghIssue, ghPullRequest));
//    }
//
//    public Iterable<RepositoryEntity> findAllProjectFromElastic() {
//        return repositoryRepo.findAll();
//    }
//}
