package com.kingcode.projectsvisualization.application.commits;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.commits')}")
public class CommitEntity {
    @Id
    private @NonNull final String id;
    private @NonNull final String commitShortInfo;
    @Field(type = FieldType.Date)
    private @NonNull final Date commitDate;
    private @NonNull final String authorName;
    private @NonNull final String committerEmail;
    private @NonNull final String ownerRepoName;

    public static CommitEntity toCommit(@NonNull GHCommit ghCommit, GHRepository ghRepository)  {
        String id = ghCommit.getUrl().toString().split("/")[ghCommit.getUrl().toString().split("/").length - 1];
        try {
            return CommitEntity.builder()
                .id(id)
                .commitShortInfo(ghCommit.getCommitShortInfo().getMessage() == null ? "commit-Short-Info" : ghCommit.getCommitShortInfo().getMessage() )
                .commitDate(ghCommit.getCommitDate() == null ? Date.from(Instant.now()) : ghCommit.getCommitDate())
                .committerEmail(ghCommit.getCommitShortInfo().getAuthor().getEmail() == null ? "noMailFound@gg.com" : ghCommit.getCommitShortInfo().getAuthor().getEmail())
                .authorName(ghCommit.getCommitShortInfo().getAuthor().getName())
                .ownerRepoName(ghRepository.getName())
                .build();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}