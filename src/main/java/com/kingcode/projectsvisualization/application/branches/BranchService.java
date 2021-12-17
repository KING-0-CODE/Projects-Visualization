package com.kingcode.projectsvisualization.application.branches;

import com.kingcode.projectsvisualization.infrastructure.github.MyGitHubService;
import lombok.RequiredArgsConstructor;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepo branchRepo;

    private final MyGitHubService myGitHubService;

    public List<BranchEntity> saveAllBranchesToElastic() throws IOException {
        List<BranchEntity> branchEntities = new ArrayList<>();
        for (GHRepository ghRepository : myGitHubService.getAllRepositories()) {
            for (GHBranch ghBranch : ghRepository.getBranches().values()) {
                branchEntities.add(BranchEntity.toBranches(ghRepository, ghBranch));
            }
        }
        return StreamSupport.stream(branchRepo.saveAll(branchEntities).spliterator(), false)
            .collect(Collectors.toList());
//        List<BranchEntity> branchEntities = myGitHubService.getAllBranches()
//            .stream()
//            .map((GHBranch ghBranch) -> BranchEntity.toBranches(ghBranch))
//            .filter(Objects::nonNull)
//            .collect(Collectors.toList());
//        return StreamSupport.stream(branchRepo.saveAll(branchEntities).spliterator(), false)
//            .collect(Collectors.toList());
    }

    public Iterable<BranchEntity> getAllBranchesFromElastic() {
        return branchRepo.findAll();
    }
}
