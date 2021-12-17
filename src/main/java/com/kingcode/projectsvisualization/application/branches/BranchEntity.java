package com.kingcode.projectsvisualization.application.branches;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.IOException;

@Getter
@Setter
@Builder
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.branches')}")
public class BranchEntity {
    @Id
    private final String id;
    private @NonNull final String branchRepoName;
    private @NonNull final String branchName;

    public static BranchEntity toBranches(GHRepository ghRepository,GHBranch ghBranch)  {
        return BranchEntity.builder()
            .id(ghRepository.getId() + ghBranch.getSHA1())
            .branchRepoName(ghRepository.getName())
            .branchName(ghBranch.getName())
            .build();
    }
}
