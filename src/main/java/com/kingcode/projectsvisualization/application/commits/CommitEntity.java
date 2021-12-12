package com.kingcode.projectsvisualization.application.commits;

import lombok.Builder;
import org.kohsuke.github.GHCommit;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.IOException;
import java.util.Date;

@Builder
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.commits')}")
public class CommitEntity {

    @Id
    private final String id;
    @Field(type = FieldType.Date)
    private final Date createdAt;
    private final String message;
    private final String authorName;
    private final String authorEmail;

    public static CommitEntity toCommit(GHCommit ghCommit) throws IOException {
        String[] split = ghCommit.getUrl().toString().split("/");
        String id = split[split.length - 1];
        return CommitEntity.builder()
            .id(id)
            .createdAt(ghCommit.getCommitDate())
            .message(ghCommit.getCommitShortInfo().getMessage())
            .authorName(ghCommit.getCommitShortInfo().getAuthor().getName())
            .authorEmail(ghCommit.getCommitShortInfo().getAuthor().getEmail())
            .build();
    }
}