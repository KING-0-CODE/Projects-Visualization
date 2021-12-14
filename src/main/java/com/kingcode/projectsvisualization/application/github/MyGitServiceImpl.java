package com.kingcode.projectsvisualization.application.github;

//import com.kingcode.projectsvisualization.application.projects.RepositoryEntity;
//import com.kingcode.projectsvisualization.application.projects.RepositoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Slf4j
//@Service
//@AllArgsConstructor
//public class MyGitServiceImpl implements MyGitHub {
//
//    private final MyGitHub myGitHub;
//



//    private final RepositoryService repositoryService;

//    @Override
//    public List<RepositoryEntity> getProjects() throws IOException {
//        List<GHRepository> ghRepositories = myGitHubService.getAllRepositories();
//ghRepositories.forEach(e -> e.);
//
//        repositoryService.saveAllProjectToElastic(ghRepositories, ghBranch, ghIssue, ghPullRequest);
//        return repositoryEntities;
//    }


//    @Override
//    public Iterable<RepositoryEntity> getProjects() throws IOException {
//        return projectService.findAllProjectFromElastic();
//    }
//
//    @Override
//    public List<CommitEntity> saveAllCommits() throws IOException {
//        Collection<GHRepository> values = gitHubApi.getMyself().getAllRepositories().values();
//
//        List<GHCommit> allCommits = new LinkedList<>();
//        List<CommitEntity> allAppCommits = new LinkedList<>();
//
//        for (GHRepository r : values) {
//            List<GHCommit> commits = r.listCommits().toList();
//            allCommits.addAll(commits);
//        }
//
//        for (GHCommit c : allCommits) {
//            String[] split = c.getUrl().toString().split("/");
//            String id = split[split.length - 1];
//            CommitEntity commit = CommitEntity.builder()
//                .id(id)
//                .authorEmail(c.getCommitShortInfo().getAuthor().getEmail())
//                .authorName(c.getCommitShortInfo().getAuthor().getName())
//                .message(c.getCommitShortInfo().getMessage())
//                .createdAt(c.getCommitDate())
//                .build();
//            allAppCommits.add(commit);
//        }
//        return allAppCommits;
//    }
//
//    @Override
//    public List<GHBranch> getBranches(int projectId) {
//        return null;
//    }
//
//    @Override
//    public List<GHOrganization> getOrganizations() throws IOException {
//        for (GHOrganization ghOrganization : gitHubApi.getMyOrganizations().values()) {
//            System.out.println(ghOrganization.getName());
//        }
//        GHMyself myself = gitHubApi.getMyself();
//        return new ArrayList<>(myself.getOrganizations());
//    }
//}
