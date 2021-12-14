package com.kingcode.projectsvisualization.application.commits;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.kohsuke.github.GHCommit;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.IOException;
import java.util.Date;

@Getter
@Setter
@Builder
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.commits')}")
public class CommitEntity {

    @Id
    private final String id;
    private final String commitShortInfo;
    @Field(type = FieldType.Date)
    private final Date commitDate;
    private final String authorName;
    private final String authorEmail;
    private final String ownerRepoName;

    public static CommitEntity toCommit(GHCommit ghCommit) throws IOException {
        String id = ghCommit.getUrl().toString().split("/")[ghCommit.getUrl().toString().split("/").length - 1];
        return CommitEntity.builder()
            .id(id)
            .commitShortInfo(ghCommit.getCommitShortInfo().getMessage())
            .commitDate(ghCommit.getCommitDate())
            .authorEmail(ghCommit.getAuthor().getName())
            .authorName(ghCommit.getCommitShortInfo().getAuthor().getEmail())
            .ownerRepoName(ghCommit.getOwner().getName())
            .build();
    }
}